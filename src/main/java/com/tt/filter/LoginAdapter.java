package com.tt.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableCaching
public class LoginAdapter implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor LoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //添加对用户是否登录的拦截器，并添加过滤项、排除项
        registry.addInterceptor(LoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/img/**","/layui/**","/fonts/**")//排除样式、脚本、图片等资源文件
                .excludePathPatterns("/login")//排除用户点击登录按钮
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/toLogin");

    }

}
