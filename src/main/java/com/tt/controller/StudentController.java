package com.tt.controller;

import com.tt.pojo.StudentEntity;
import com.tt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *学员controller
 */
@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping("/toStudentMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/student/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getListByPage")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.studentService.findStudentByPage2(page,limit);
	}


	@ResponseBody
	@RequestMapping(value="/getListByPageAndPlace")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
											@RequestParam(value = "limit", defaultValue = "5") int limit,@RequestParam(value = "placeId") String placeId){
		return this.studentService.findStudentByPage2(page,limit,placeId);
	}


	@ResponseBody
	@RequestMapping(value="/getList")
	public List<StudentEntity> getList(){
		return this.studentService.findAllStudent();
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("/student/s_add");
		return model;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "studentId") int studentId) {
		ModelAndView mv = new ModelAndView("/student/s_editor");;
		StudentEntity studentEntity = this.studentService.findStudentById(studentId);
		mv.addObject("studentEntity", studentEntity);
		mv.addObject("studentId", studentId);
		return mv;
	}

	@RequestMapping("/toupdate2")
	public ModelAndView toUpdate2(@RequestParam(value = "studentId") int studentId) {
		ModelAndView mv = new ModelAndView("/student/s_editor2");;
		StudentEntity studentEntity = this.studentService.findStudentById(studentId);
		mv.addObject("studentEntity", studentEntity);
		mv.addObject("studentId", studentId);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(StudentEntity studentEntity){
		StudentEntity studentEntity1 = this.studentService.saveStudent(studentEntity);
		if(studentEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(StudentEntity studentEntity){
		StudentEntity studentEntity1 = this.studentService.updateStudent(studentEntity);

		if(studentEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	/**
	 * 家长修改学生信息
	 * @param studentEntity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update2")
	public String update2(StudentEntity studentEntity){
		StudentEntity studentEntity1 = this.studentService.findStudentById(studentEntity.getId());
		studentEntity.setPlaceId(studentEntity1.getPlaceId());
		studentEntity.setClassHours(studentEntity1.getClassHours());
		studentEntity.setRegistrTime(studentEntity1.getRegistrTime());
		studentEntity.setSn(studentEntity1.getSn());

		StudentEntity studentEntity2 = this.studentService.saveStudent(studentEntity);
		if(studentEntity2!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.studentService.deleteStudent(id);
	}

	@ResponseBody
	@RequestMapping(value = "/findStuByPlaceId")
	public List<StudentEntity> findStudentByPlaceId(String placeId){
		return this.studentService.findStudentByPlaceId(placeId);
	}

	/**
	 * 查询学号是否存在
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findSn")
	public String findSn(String sn){
		StudentEntity studentEntity = this.studentService.findSn(sn);
		if(studentEntity!=null){
			return "0";
		}else{
			return "1";
		}
	}

	/**
	 * 根据学号查询学生信息
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/findUserInfoBySn")
	public StudentEntity findUserInfoBySn(String sn){
		return this.studentService.findSn(sn);
	}
}
