package com.tt.controller;

import java.util.List;
import java.util.Map;


import com.tt.pojo.CourseEntity;
import com.tt.service.CourseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *课程controller
 */
@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping("/toCourseMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/course/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getList")
	public Map<String,Object> getDatasource(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.courseService.findCourseByPage(page,limit);
	}

	@ResponseBody
	@RequestMapping(value="/getAll")
	public List<CourseEntity> getAll(){
		return this.courseService.findAllCourse();
	}


	@ResponseBody
	@RequestMapping(value="/getAllByPlace")
	public List<CourseEntity> getAllByPlace(@RequestParam(value = "placeId") String placeId){
		return this.courseService.findAllCourseByPlace(placeId);
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("/course/s_add");
		return model;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "courseId") int courseId) {
		ModelAndView mv = new ModelAndView("/course/s_editor");;
		CourseEntity courseEntity = this.courseService.findCourseById(courseId);
		mv.addObject("courseEntity", courseEntity);
		mv.addObject("courseId", courseId);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(CourseEntity courseEntity){
		CourseEntity courseEntity1 = this.courseService.saveCourse(courseEntity);
		if(courseEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(CourseEntity courseEntity){
		CourseEntity courseEntity1 = this.courseService.saveCourse(courseEntity);

		if(courseEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.courseService.deleteCourse(id);
	}
}
