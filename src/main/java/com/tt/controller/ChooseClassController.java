package com.tt.controller;

import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.StudentEntity;
import com.tt.service.ChooseClassService;
import com.tt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 *选课controller
 */
@Controller
@RequestMapping("/chooseClass")
public class ChooseClassController {
	@Autowired
	private ChooseClassService chooseClassService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/toChooseClassShow")
	public ModelAndView toChooseClassShow(@RequestParam(value = "studentId") int studentId) {
		ModelAndView model = new ModelAndView();
		StudentEntity studentEntity = this.studentService.findStudentById(studentId);
		model.addObject("placeId",studentEntity.getPlaceId());
		model.setViewName("./chooseClass/s_show");
		return model;
	}

	@RequestMapping("/toChooseClassMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("./chooseClass/s_main");
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/getListByPageAndPlace")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
                                            @RequestParam(value = "limit", defaultValue = "7") int limit, @RequestParam(value = "placeId") String placeId){
		return this.chooseClassService.findAllChooseClassByPage(page,limit,placeId);
	}


	@ResponseBody
	@RequestMapping(value="/getListByPageAndPlaceAndCourse")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
                                            @RequestParam(value = "limit", defaultValue = "7") int limit, @RequestParam(value = "placeId") String placeId, @RequestParam(value = "courseId") String courseId){
		return this.chooseClassService.findAllChooseClassByPageAndCourse(page,limit,placeId,courseId);
	}

	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("./chooseClass/s_add");
		return model;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "chooseClassId") String chooseClassId) {
		ModelAndView mv = new ModelAndView("./chooseClass/s_editor");
		ChooseClassEntity chooseClassEntity = this.chooseClassService.findChooseClassById(chooseClassId);
		mv.addObject("chooseClassEntity", chooseClassEntity);
		mv.addObject("chooseClassId", chooseClassId);
		return mv;
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(ChooseClassEntity chooseClassEntity){
		ChooseClassEntity chooseClassEntity1 = this.chooseClassService.saveChooseClass(chooseClassEntity);
		if(chooseClassEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(ChooseClassEntity chooseClassEntity){
		ChooseClassEntity chooseClassEntity1 = this.chooseClassService.saveChooseClass(chooseClassEntity);

		if(chooseClassEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}



	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.chooseClassService.deleteChooseClass(id);
	}

	@ResponseBody
	@RequestMapping(value="/getListAll")
	public List<ChooseClassEntity> getListByPage(@RequestParam(value = "placeId") String placeId){
		return this.chooseClassService.findAllChooseClassByPlaceId(placeId);
	}
}
