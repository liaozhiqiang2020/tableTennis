package com.tt.service.impl;

import com.tt.pojo.RoleEntity;
import com.tt.pojo.UserEntity;
import com.tt.repository.RoleRepository;
import com.tt.repository.UserRepository;
import com.tt.service.UserService;
import com.tt.util.DateJsonValueProcessor;
import com.tt.util.MD5Util;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

        map.put("data", userList);
        map.put("total", total);
        return map;
    }

    /**
     * 查询所有用户
     * @return 所有用户集合
     */
    @Override
    @Transactional
    public List<UserEntity> findAllUser() {
        return this.userRepository.findAll();
    }

    /**
     * 查询所有状态为1的用户
     * @param request
     * @return 所有状态为1 的用户
     */
    @Override
    @Transactional
    public String findAllByStatus(HttpServletRequest request) {
        return "";
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }


    /**
     * 逻辑删除用户
     * @param user 需要删除的User对象
     */
    @Override
    @Transactional
    public void deleteUser(UserEntity user) {
        user.setStatus(0);
        this.userRepository.save(user);
    }

    /**
     * 根据id查询用户
     * @param userId user主键
     * @return 用户信息
     */
    @Override
    @Transactional
    public UserEntity findUserById(int userId) {
        return this.userRepository.findUserById(userId);
    }

    @Override
    public Set<RoleEntity> findUserRole(int userId) {
        return null;
    }

    @Override
    public Set<RoleEntity> deleteUserRole(Map<String, Object> listMap) {
        return null;
    }

    @Override
    public Set<RoleEntity> addUserRole(int userId, int roleId) {
        return null;
    }

    @Override
    public List<RoleEntity> userUnRole(int userId) {
        return null;
    }


    /**
     * 查询所有公司 
     * @return 所有公司集合
     */
    @Override
    public List<Object> findAllplace() {

        List<Object> list = new ArrayList<>();

        return list;
    }

    /**
     * 根据公司名字查询所属公司
     * @param gradeId 公司分类
     * @param pId 公司分类
     * @return 所属的公司信息
     */
    @Override
    public String findCompanyNameByGradeType(int gradeId, int pId) {
        String companyName="";


        return companyName;
    }

    /**
     *  密码修改
     * @param request 请求
     * @param session  用户
     * @param response  响应
     * @return 修改结果
     */
    @Override
    public String changePwd(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
//        String old = request.getParameter("password");
//        String new1 = request.getParameter("password1");
//        String new2 = request.getParameter("password2");
//        String oldPwd = MD5Util.encode(old);
//        UserEntity user = (UserEntity) session.getAttribute("user");
//        String message = "";
//        if (old.equals(new1)){
//            message="新密码不能与原密码相同";
//        }else if (oldPwd.equals(user.getAuthenticationString())){
//            user.setAuthenticationString(MD5Util.encode(new1));
//            this.userRepository.save(user);
//            message="修改成功,请重新登录";
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            if (auth != null){
//                new SecurityContextLogoutHandler().logout(request, response, auth);
//            }
//        }else if(!oldPwd.equals(user.getAuthenticationString()) ){
//            message = "原密码错误";
//        }else {
//            message = "密码修改失败";
//        }
//        return message;
        return "";
    }

    @Override
    public UserEntity findUserByName(String username) {
        return this.userRepository.findUserByUserName(username);
    }
}