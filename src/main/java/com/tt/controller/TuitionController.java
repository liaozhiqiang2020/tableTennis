package com.tt.controller;

import com.tt.pojo.TuitionEntity;
import com.tt.service.TuitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *缴费controller
 */
@Controller
@RequestMapping("/tuition")
public class TuitionController {
	@Autowired
	private TuitionService tuitionService;

	@RequestMapping("/toTuitionMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/tuition/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getList")
	public Map<String,Object> getDatasource(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.tuitionService.findTuitionByPage(page,limit);
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("/tuition/s_add");
		return model;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "tuitionId") int tuitionId) {
		ModelAndView mv = new ModelAndView("/tuition/s_editor");;
		TuitionEntity tuitionEntity = this.tuitionService.findTuitionById(tuitionId);
		mv.addObject("tuitionEntity", tuitionEntity);
		mv.addObject("tuitionId", tuitionId);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(TuitionEntity tuitionEntity){
		TuitionEntity tuitionEntity1 = this.tuitionService.saveTuition(tuitionEntity);
		if(tuitionEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(TuitionEntity tuitionEntity){
		TuitionEntity tuitionEntity1 = this.tuitionService.saveTuition(tuitionEntity);

		if(tuitionEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.tuitionService.deleteTuition(id);
	}
}
