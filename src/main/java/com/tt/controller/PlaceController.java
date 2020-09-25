package com.tt.controller;

import com.tt.pojo.PlaceEntity;
import com.tt.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 *学员controller
 */
@Controller
@RequestMapping("/place")
public class PlaceController {
	@Autowired
	private PlaceService placeService;

	@RequestMapping("/toPlaceMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/place/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getList")
	public Map<String,Object> getDatasource(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.placeService.findPlaceByPage(page,limit);
	}
	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("/place/s_add");
		return model;
	}
	
	@RequestMapping(value="/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "placeId") int placeId) {
		ModelAndView mv = new ModelAndView("/place/s_editor");
		PlaceEntity placeEntity = this.placeService.findPlaceById(placeId);
		mv.addObject("placeEntity", placeEntity);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(PlaceEntity placeEntity){
		PlaceEntity placeEntity1 = this.placeService.savePlace(placeEntity);
		if(placeEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(PlaceEntity placeEntity){
		PlaceEntity placeEntity1 = this.placeService.savePlace(placeEntity);

		if(placeEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.placeService.deletePlace(id);
	}
}
