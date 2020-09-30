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


    @Override
    public UserEntity findUserByName(String username) {
        return this.userRepository.findUserByUserName(username);
    }

    @Override
    public int deleteUserById(int userId) {
        return 0;
    }
}