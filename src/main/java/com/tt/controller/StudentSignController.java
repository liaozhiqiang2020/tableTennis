package com.tt.controller;

import com.tt.pojo.StudentSignEntity;
import com.tt.service.StudentSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/toadd")
	public ModelAndView toadd(HttpServletRequest request) {
		HttpSession session   =   request.getSession();
		String userName = (String) session.getAttribute("user");
		ModelAndView model = new ModelAndView("/studentSign/s_add");
		model.addObject("userName",userName);
		return model;
	}

	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(StudentSignEntity studentSignEntity){
		StudentSignEntity studentSignEntity1 = this.studentSignService.saveStudentSign(studentSignEntity);
		if(studentSignEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}

}
