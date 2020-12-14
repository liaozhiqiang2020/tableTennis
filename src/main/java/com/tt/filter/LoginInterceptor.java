package com.tt.filter;

import com.tt.pojo.UserEntity;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Configuration
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        StringBuffer url = request.getRequestURL();
        request.getSession().setAttribute("url",url.toString());
        HttpSession session = request.getSession(true);
        UserEntity userEntity= (UserEntity) session.getAttribute("user");
        if(null!=userEntity) {//已登录
            return true;
        }else {//未登录
            response.sendRedirect(request.getContextPath()+"/toLogin");
            return false;
        }
    }

    //请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("postHandle被调用");
    }

    //在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("afterCompletion被调用");
    }
}
