package com.tt.controller;

import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.StudentEntity;
import com.tt.service.ChooseClassRecordService;
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
@RequestMapping("/chooseClassRecord")
public class ChooseClassRecordController {
	@Autowired
	private ChooseClassRecordService chooseClassRecordService;

	@RequestMapping("/toChooseClassMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("./chooseClassRecord/s_main");
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/getListByPageAndPlace")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
											@RequestParam(value = "limit", defaultValue = "7") int limit,@RequestParam(value = "placeId") String placeId){
		return this.chooseClassRecordService.findAllChooseClassByPage(page,limit,placeId);
	}

}
