package com.tt.controller;

import com.tt.pojo.MemberEntity;
import com.tt.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 *会员controller
 */
@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberService MemberService;

	@RequestMapping("/toMemberMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("./member/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getList")
	public Map<String,Object> getDatasource(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit){
        return this.MemberService.findMemberByPage(page,limit);
	}

	@ResponseBody
	@RequestMapping(value="/getListByPageAndOther")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
											@RequestParam(value = "limit", defaultValue = "5") int limit,
											@RequestParam(value = "name") String name,
											@RequestParam(value = "tel") String tel){
		return this.MemberService.getListByPageAndOther(page,limit,name,tel);
	}

	@ResponseBody
	@RequestMapping(value="/getAll")
	public List<MemberEntity> getAll(){
		return this.MemberService.findAllMember();
	}

	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("./member/s_add");
		return model;
	}
	
	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "memberId") int memberId) {
		ModelAndView mv = new ModelAndView("./member/s_editor");;
		MemberEntity MemberEntity = this.MemberService.findMemberById(memberId);
		mv.addObject("memberEntity", MemberEntity);
		mv.addObject("memberId", memberId);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(MemberEntity MemberEntity){
		MemberEntity MemberEntity1 = this.MemberService.saveMember(MemberEntity);
		if(MemberEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(MemberEntity MemberEntity){
		MemberEntity MemberEntity1 = this.MemberService.saveMember(MemberEntity);

		if(MemberEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.MemberService.deleteMember(id);
	}
}
