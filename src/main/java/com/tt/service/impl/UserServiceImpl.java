package com.tt.service.impl;

import com.tt.pojo.UserEntity;
import com.tt.repository.UserRepository;
import com.tt.service.UserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

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


}