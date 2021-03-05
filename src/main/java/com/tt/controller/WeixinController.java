package com.tt.controller;

import com.tt.pojo.NoticeEntity;
import com.tt.pojo.StudentEntity;
import com.tt.pojo.WxUserInfoEntity;
import com.tt.service.*;
import com.tt.weixinpay.vo.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.weixin4j.WeixinException;
import org.weixin4j.WeixinSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * 微信小程序相关控制
 *
 * @author: lzq
 * @date: 2018年7月3日
 */
@Controller
@RequestMapping("/weixin")
public class WeixinController extends WeixinSupport {
    @Autowired
    private WeiXinPayService weiXinPayService;
    @Autowired
    private WxUserInfoService wxUserInfoService;
    @Autowired
    private CoachService coachService;
    @Autowired
    private NoticeService noticeService;
    @Autowired
    private StudentService studentService;


    /**
     * 小程序后台登录，向微信平台发送获取access_token请求，并返回openId
     *
     * @param code
     * @return openid
     * @throws WeixinException
     * @throws IOException
     * @author: lzq
     * @date: 2018年7月3日
     * @since Weixin4J 1.0.0
     */
    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(String code) throws WeixinException, IOException {
        return this.weiXinPayService.login(code);
    }

    /**
     * 发起微信支付
     *
     * @param openid
     * @param request
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping("/wxPay")
    @ResponseBody
    public Json wxPay(String openid, HttpServletRequest request, String paidOrderId, String money) {
        return this.weiXinPayService.wxPay(openid, request, paidOrderId, money);
    }

    /**
     * 微信支付
     *
     * @throws Exception
     * @throws WeixinException
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping(value = "/wxNotify")
    @ResponseBody
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) throws Exception {
        this.weiXinPayService.wxNotify(request, response);
    }


    /**
     * 获取用户信息
     *
     * @throws WeixinException
     * @throws IOException
     * @author: lzq
     * @date: 2018年7月3日
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public String getUserInfo(String sessionkey, String encryptedData, String iv, String openid, String userInfos) {
        return this.weiXinPayService.getUserInfo(sessionkey, encryptedData, iv, openid, userInfos);
    }

    /**
     * 保存用户信息
     */
    @RequestMapping("/saveUserInfo")
    @ResponseBody
    public void saveUserInfo(String openId, String userInfo) {

        this.wxUserInfoService.saveUserInfoAndPhoneAndOpenId(openId, userInfo);
    }

    /**
     * 查询用户信息
     */
    @RequestMapping("/findWxUserInfoByOpenId")
    @ResponseBody
    public WxUserInfoEntity findWxUserInfoByOpenId(String openId) {
        WxUserInfoEntity wxUserInfoEntity = this.wxUserInfoService.findWxUserInfoByOpenId(openId);
        return wxUserInfoEntity;
    }

    /**
     * 查询教练和课程列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findCoachAndClass")
    public List<Map<String, Object>> findCoachAndClass(String openCode,String state){
        return this.coachService.findCoachAndClass(state);
    }

    /**
     * 查询公告
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findGongGaoNotice")
    public List<NoticeEntity> findGongGaoNotice(Integer type){
        return this.noticeService.findAllNoticeByType(type);
    }

    /**
     * 查询手机号下绑定的学员
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/findStudentByPhone")
    public List<StudentEntity> findStudentByPhone(String phone){
        return this.studentService.findStudentByPhone(phone);
    }

    @GetMapping(value = "/showImg")
    public void showImg(HttpServletResponse response, String pathName) {
        File imgFile = new File(pathName);
        FileInputStream fin = null;
        OutputStream output = null;
        try {
            output = response.getOutputStream();
            fin = new FileInputStream(imgFile);
            byte[] arr = new byte[1024 * 10];
            int n;
            while ((n = fin.read(arr)) != -1) {
                output.write(arr, 0, n);
            }
            output.flush();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            output.close();
        } catch (IOException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}