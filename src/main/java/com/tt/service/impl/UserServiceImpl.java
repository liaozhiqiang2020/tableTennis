package com.tt.service.impl;

import com.tt.pojo.UserEntity;
import com.tt.repository.UserRepository;
import com.tt.service.UserService;
import com.tt.util.MD5Util;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService<UserEntity> {

    @Resource
    UserRepository userRepository;


    /**
     * 分页查询所有用户
     * @param page 起始个数
     * @param pageSize 截至个数
     * @return 用户信息
     */
    @Override
    @Transactional
    public Map<String,Object> findEntitiesPager(int page, int pageSize) {
        Map<String,Object> map = new HashedMap();
        int offset = ((page - 1) * pageSize);
        int total = this.userRepository.findPriceTotal();
        List<UserEntity> userList = this.userRepository.findAllUserByPage(offset, pageSize);

        map.put("code", 0);
        map.put("data", userList);
        map.put("count", total);
        return map;
    }

    @Override
    public UserEntity findUserById(int userId) {
        return this.userRepository.findUserById(userId);
    }

    @Override
    public UserEntity findUserByName(String username) {
        return this.userRepository.findUserByUserName(username);
    }


    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = sf.format(date);

        userEntity.setType(0);
        userEntity.setStatus(0);
        userEntity.setAuthenticationString("123456");
        userEntity.setCreateDatetime(time);
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        UserEntity userEntity1 = this.userRepository.findUserById(userEntity.getId());
        String pwd = userEntity1.getAuthenticationString();
        userEntity.setAuthenticationString(pwd);
        return this.userRepository.save(userEntity);
    }

    @Override
    public int deleteUser(int userId) {
        return this.userRepository.deleteById(userId);
    }

    @Override
    public String changePwd(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        String old = request.getParameter("password");
        String new1 = request.getParameter("password1");
        String new2 = request.getParameter("password2");
        String oldPwd = MD5Util.encode(old);
        UserEntity user = (UserEntity) session.getAttribute("user");
        String message = "";
        if (old.equals(new1)){
            message="新密码不能与原密码相同";
        }else if (oldPwd.equals(user.getAuthenticationString())){
            user.setAuthenticationString(MD5Util.encode(new1));
            this.userRepository.save(user);
            message="修改成功,请重新登录";
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null){
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
        }else if(!oldPwd.equals(user.getAuthenticationString()) ){
            message = "原密码错误";
        }else {
            message = "密码修改失败";
        }
        return message;
    }


}