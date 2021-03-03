package com.tt.controller;

import com.tt.pojo.UserEntity;
import com.tt.pojo.vo.HomeVO;
import com.tt.service.HomeService;
import com.tt.service.StudentService;
import com.tt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * 初始页面
 */
@Controller
public class DefaultController {

    @Autowired
    private HomeService homeService;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentService studentService;

    /**
     * 页面跳转到 初始页面
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index() {
        return new ModelAndView("./home");
    }
    /**
     * 页面跳转到 初始页面
     * @return
     */
    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("./home");
    }

    /**
     * 登陆页面跳转控制
     * @param error 不正确
     * @param logout 退出
     * @return 页面跳转
     */
    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "不正确的用户名和密码");
        }
        if (logout != null) {
            model.addObject("msg", "你已经成功退出");
        }
        model.setViewName("login");
        return model;
    }

    /**
     *
     * @return
     */
    @GetMapping("/urpMgmt/roleIndex")
    public ModelAndView roleIndex() {
        return new ModelAndView("/userRolePermissionMgmt/roleList");
    }

   /* *//**
     * 403
     * @return 403页面
     *//*
    @GetMapping("/error")
    public String error403() {
        return "/error/403";
    }*/

    /**
     * 今天订单数
     * @return
     */
    @RequestMapping("/getYesterdayOrderCount")
    public String  getYesterdayOrderCount(){
        return null;
    }

    /**
     *
     * @param request
     * @return
     */
    @GetMapping("/getCount")
    public HomeVO getCount(HttpServletRequest request){


        return null;
    }

    /**
     * 登陆页面跳转控制
     * @return 页面跳转
     */
    @PostMapping("/login")
    public ModelAndView verPwd(@RequestParam(value = "username", required = false) String username,
                               @RequestParam(value = "password", required = false) String password, HttpSession session, HttpServletResponse response, HttpServletRequest request, RedirectAttributes attributes, Map<String,Object> map) throws IOException {
        ModelAndView model = new ModelAndView();
        String url = (String) session.getAttribute("url");
        UserEntity userEntity = this.userService.findUserByName(username);
        if(userEntity!=null && userEntity.getAuthenticationString().equals(password)){
            Cookie c1 = new Cookie("loginName", username);
            c1.setPath("/");
            response.addCookie(c1);
            session.setAttribute("user", userEntity);
            request.getSession().setMaxInactiveInterval(5*60);
            if(url.contains("/studentSign/")){
                model.setViewName("redirect:"+url);
            }else{
                if(userEntity.getType()==1){
                    model.setViewName("redirect:"+request.getContextPath().replace("tt","")+"parent/toParentMgr");
                }else{
                    model.setViewName("home");
                }

            }
        }else{
            model.addObject("error", "不正确的用户名和密码");
            model.setViewName("login");
        }


        return model;
    }


    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView();
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        model.setViewName("login");
        return model;
    }

}
