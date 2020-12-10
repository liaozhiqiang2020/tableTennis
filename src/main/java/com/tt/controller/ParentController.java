package com.tt.controller;

import com.tt.pojo.ChooseClassEntity;
import com.tt.pojo.ChooseClassRecordEntity;
import com.tt.pojo.StudentEntity;
import com.tt.pojo.UserEntity;
import com.tt.service.ChooseClassRecordService;
import com.tt.service.ChooseClassService;
import com.tt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *家长controller
 */
@Controller
@RequestMapping("/parent")
public class ParentController {
	@Autowired
	private StudentService studentService;
	@Autowired
	private ChooseClassService chooseClassService;
	@Autowired
	private ChooseClassRecordService chooseClassRecordService;

	@RequestMapping("/toParentMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("/student/parentHome2");
		return model;
	}

	@RequestMapping("/toTest1")
	public ModelAndView toTest1(ModelAndView model) {
		model.setViewName("/student/test1");
		return model;
	}

	@RequestMapping("/toTest2")
	public ModelAndView toTest2(ModelAndView model, HttpSession session) {
		UserEntity userEntity = (UserEntity) session.getAttribute("user");
		String studentSn = userEntity.getUserName();
		StudentEntity studentEntity = this.studentService.findSn(studentSn);
		model.setViewName("/student/test4");
		model.addObject("studentId",studentEntity.getId());
		model.addObject("placeId",studentEntity.getPlaceId());
		return model;
	}

	@RequestMapping("/toTest3")
	public ModelAndView toTest3(ModelAndView model) {
		model.setViewName("/student/test3");
		return model;
	}

	@ResponseBody
	@RequestMapping("/submitClass")
	public String submitClass(@RequestParam(value="ids") String ids,@RequestParam(value="classCount") String classCount,HttpSession session){
		try {
			String[] idStr = ids.split(",");
			StringBuffer stringBuffer = new StringBuffer();
			for (String classId:idStr){
				ChooseClassEntity chooseClassEntity = this.chooseClassService.findChooseClassById(classId);
				stringBuffer.append(chooseClassEntity.getWeek()+chooseClassEntity.getStartTime()+"-"+chooseClassEntity.getEndTime()+"\t");
			}
			UserEntity userEntity = (UserEntity) session.getAttribute("user");
			StudentEntity studentEntity = this.studentService.findSn(userEntity.getUserName());
			ChooseClassRecordEntity chooseClassRecordEntity = new ChooseClassRecordEntity();
			chooseClassRecordEntity.setPlaceId(studentEntity.getPlaceId());
			chooseClassRecordEntity.setStudentId(String.valueOf(studentEntity.getId()));
			chooseClassRecordEntity.setExpectCount(Integer.parseInt(classCount));
			chooseClassRecordEntity.setClassContent(stringBuffer.toString());

			this.chooseClassRecordService.saveChooseClass(chooseClassRecordEntity);
			return "0";
		}catch (Exception e){
			e.printStackTrace();
			return "1";
		}
	}
}
