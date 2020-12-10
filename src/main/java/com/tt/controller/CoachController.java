package com.tt.controller;

import com.tt.pojo.CoachEntity;
import com.tt.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *教练controller
 */
@Controller
@RequestMapping("/coach")
public class CoachController {
	@Autowired
	private CoachService coachService;

	@RequestMapping("/toCoachMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/coach/s_main");
		return model;
	}

	@ResponseBody
	@RequestMapping(value="/getListByPage")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
											@RequestParam(value = "limit", defaultValue = "7") int limit){
		return this.coachService.findAllCoachByPage(page,limit);
	}


	@ResponseBody
	@RequestMapping(value="/getListByOnWork")
	public List<CoachEntity> findCoachEntityByOnWork(){
		return this.coachService.findCoachEntityByOnWork();
	}

	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("/coach/s_add");
		return model;
	}

	@RequestMapping("/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "coachId") Integer coachId) {
		ModelAndView mv = new ModelAndView("/coach/s_editor");
		CoachEntity coachEntity = this.coachService.findCoachEntityById(coachId);
		mv.addObject("coachEntity", coachEntity);
		mv.addObject("coachId", coachId);
		return mv;
	}



	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(CoachEntity coachEntity){
		coachEntity.setOnLeave("0");
		coachEntity.setOnWork("0");
		CoachEntity coachEntity1 = this.coachService.saveCoach(coachEntity);
		if(coachEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}


	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(CoachEntity coachEntity){
		CoachEntity coachEntity1 = this.coachService.saveCoach(coachEntity);
		if(coachEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	/**
	 * 个人信息上传
	 * @return {Result}
	 */
	@RequestMapping(value = "/uploadImg", method = {RequestMethod.POST})
	@ResponseBody
	public Object uploadImg(@RequestParam(value="file",required=false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String strDateFormat = "yyyyMMddHHmmss";
		SimpleDateFormat format = new SimpleDateFormat(strDateFormat);
		String prefix="";
		String dateStr="";
		//保存上传
		OutputStream out = null;
		InputStream fileInput=null;
		try{
			if(file!=null){
				String originalName = file.getOriginalFilename();
				prefix=originalName.substring(originalName.lastIndexOf(".")+1);
				dateStr = format.format(new Date());
				String filepath = "E:/upload/" + dateStr + "." + prefix;
				filepath = filepath.replace("\\", "/");
				File files=new File(filepath);
				//打印查看上传路径
				System.out.println(filepath);
				if(!files.getParentFile().exists()){
					files.getParentFile().mkdirs();
				}
				file.transferTo(files);
			}
		}catch (Exception e){
		}finally{
			try {
				if(out!=null){
					out.close();
				}
				if(fileInput!=null){
					fileInput.close();
				}
			} catch (IOException e) {
			}
		}
		Map<String,Object> map2=new HashMap<>();
		Map<String,Object> map=new HashMap<>();
		map.put("code",0);
		map.put("msg","");
		map.put("data",map2);
		map2.put("src","E:/upload/" + dateStr + "." + prefix);
		return map;
	}



}
