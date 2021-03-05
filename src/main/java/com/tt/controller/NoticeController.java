package com.tt.controller;

import com.tt.pojo.NoticeEntity;
import com.tt.pojo.PlaceEntity;
import com.tt.pojo.UserEntity;
import com.tt.service.NoticeService;
import com.tt.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *消息通知controller
 */
@Controller
@RequestMapping("/notice")
public class NoticeController {
	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/toNoticeMgr")
	public ModelAndView dataList(ModelAndView model) {
		model.setViewName("./notice/s_main");
		return model;
	}
	
	@ResponseBody
	@RequestMapping(value="/getListByPage")
	public Map<String,Object> getListByPage(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "5") int limit,
			@RequestParam(value = "type") Integer type){
        return this.noticeService.findAllNoticeByPage(page,limit,type);
	}

	@ResponseBody
	@RequestMapping(value="/getList")
	public List<NoticeEntity> getList(){
		return this.noticeService.findAllNotice();
	}


	
	@RequestMapping(value = "/toadd")
	public ModelAndView toadd() {
		ModelAndView model = new ModelAndView("./notice/s_add");
		return model;
	}
	
	@RequestMapping(value="/toupdate")
	public ModelAndView toUpdate(@RequestParam(value = "noticeId") int noticeId) {
		ModelAndView mv = new ModelAndView("./notice/s_editor");
		NoticeEntity noticeEntity = this.noticeService.findNoticeById(noticeId);
		mv.addObject("noticeEntity", noticeEntity);
		return mv;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String add(NoticeEntity noticeEntity,HttpServletRequest request){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date currentTime = new Date();
		HttpSession session   =   request.getSession();
		UserEntity userEntity = (UserEntity) session.getAttribute("user");

		noticeEntity.setPublishDate(formatter.format(currentTime));
		noticeEntity.setPublishId(userEntity.getId());
		NoticeEntity noticeEntity1 = this.noticeService.saveNotice(noticeEntity);

		if(noticeEntity1!=null){
			return "0";
		}else{
			return "1";
		}

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/update")
	public String update(NoticeEntity noticeEntity){
		NoticeEntity noticeEntity1 = this.noticeService.updateCoach(noticeEntity);

		if(noticeEntity1!=null){
			return "0";
		}else{
			return "1";
		}
	}

	@ResponseBody
	@RequestMapping(value = "/delete")
	public int delete(int id){
		return this.noticeService.deleteById(id);
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
				String filepath = "/usr/local/bin/upload/" + dateStr + "." + prefix;
//				String filepath = "E:/upload/" + dateStr + "." + prefix;
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
		map2.put("src","/usr/local/bin/upload/" + dateStr + "." + prefix);
//		map2.put("src","E:/upload/" + dateStr + "." + prefix);
		return map;
	}
}
