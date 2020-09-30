package com.tt.service;


import com.tt.pojo.RoleEntity;
import com.tt.pojo.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 魏帅志
 * @param <T>
 */
public interface UserService<T>  {

    /**
     * 分页查询所有user
     * @param page  起始个数
     * @param pageSize  截至个数
     * @return 分页集合
     */
    Map<String,Object> findEntitiesPager(int page, int pageSize);



    /**
     * 根据Id查询User
     * @param userId user主键
     * @return 查询结果
     */
    UserEntity findUserById(int userId);



    /**
     * 用户名查用户对象
     * @param username
     * @return
     */
    UserEntity findUserByName(String username);

    int deleteUserById(int userId);


}
