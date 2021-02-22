package com.tt.controller;

import com.tt.pojo.StudentEntity;
import com.tt.pojo.StudentSignEntity;
import com.tt.pojo.UserEntity;
import com.tt.service.StudentService;
import com.tt.service.StudentSignService;
import com.tt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.weixin4j.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 *学员签到controller
 */
@Controller
@RequestMapping("/studentSign")
public class StudentSignController {
	@Autowired
	private StudentSignService studentSignService;
	@Autowired
	private UserService userService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/toStudentSignMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/studentSign/s_main");
		return model;
	}

	@RequestMapping("/toStudentSignShow")
	public ModelAndView toStudentSignShow(ModelAndView model) {
		model.setViewName("/studentSign/s_show");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getListByPage")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.studentSignService.findStudentSignByPage2(page,limit);
	}

	@ResponseBody
	@RequestMapping(value="/getListByPageAndOther")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
											@RequestParam(value = "limit", defaultValue = "5") int limit,
											@RequestParam(value = "name") String name,
											@RequestParam(value = "studentName") String studentName,
											@RequestParam(value = "startTime") String startTime,
											@RequestParam(value = "endTime") String endTime){
		return this.studentSignService.getListByPageAndOther(page,limit,name,studentName,startTime,endTime);
	}

	@RequestMapping(value = "/toadd")
	public ModelAndView toadd(HttpServletRequest request,int id,String name,int placeId,String placeName) {
		HttpSession session   =   request.getSession();
		UserEntity userEntity2 = (UserEntity) session.getAttribute("user");
		String userName = userEntity2.getUserName();
		UserEntity userEntity = this.userService.findUserByName(userName);
		ModelAndView model = new ModelAndView("/studentSign/s_add");
		model.addObject("userId",userEntity.getId());
		model.addObject("userName",userName);
		model.addObject("studentId",id);
		model.addObject("studentName",name);
		model.addObject("placeId",placeId);
		model.addObject("placeName",placeName);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(StudentSignEntity studentSignEntity,HttpServletRequest request){
		try {
			StudentSignEntity studentSignEntity1 = this.studentSignService.saveStudentSign(studentSignEntity);
			StudentEntity studentEntity = this.studentService.findStudentById(studentSignEntity1.getStudentId());
			if(!studentEntity.getUnitPrice().equals("") && !studentEntity.getMoney().equals("")){
				studentEntity.setMoney(String.valueOf(Integer.parseInt(studentEntity.getMoney())-Integer.parseInt(studentEntity.getUnitPrice())));
			}else{
				studentEntity.setClassHours(String.valueOf(Integer.parseInt(studentEntity.getClassHours())-1));
			}

			this.studentService.updateStudent(studentEntity);
			if(studentSignEntity1!=null){
				return "0";
			}else{
				return "1";
			}
		}catch (Exception e){
			return "1";
		}

	}

	/**
	 * 查询学员当天是否签到
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/querySign")
	public String querySign(int id){
		StudentSignEntity studentSignEntity = this.studentSignService.querySign(id);
		if(studentSignEntity!=null){
			return "0";
		}else{
			return "1";
		}
	}

}
