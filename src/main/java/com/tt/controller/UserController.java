package com.tt.controller;

import com.tt.pojo.RoleEntity;
import com.tt.pojo.StudentEntity;
import com.tt.pojo.UserEntity;
import com.tt.service.UserService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户信息
 */
@RestController
public class UserController {

    @Resource
    UserService userService;

    @GetMapping("/user/allPage")
    public Map<String,Object> findAllUserPage(@Param("page") String page, @Param("limit") String pageSize) {
        return this.userService.findEntitiesPager(Integer.parseInt(page), Integer.parseInt(pageSize));
    }


    /**
     * 更新用户
     * @return 更新的用户信息条数
     */
    @PostMapping("/user/update")
    public String updateUser(UserEntity userEntity) {
        UserEntity userEntity1 = this.userService.saveUser(userEntity);
        if(userEntity1!=null){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 保存用户
     * @return 保存的用户信息条数
     */
    @PostMapping("/user/add")
    public String saveUser(UserEntity userEntity) {
        UserEntity userEntity1 = this.userService.saveUser(userEntity);
        if(userEntity1!=null){
            return "0";
        }else{
            return "1";
        }
    }

    /**
     * 跳转到userManagement页面
     *
     * @return 用户管理view 对象
     */
    @GetMapping(value = "/user/userManagement")
    public ModelAndView turnToUserManagement() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("./user/s_main");
        return mv;
    }


    @RequestMapping(value = "/user/toadd")
    public ModelAndView toadd() {
        ModelAndView model = new ModelAndView("/user/s_add");
        return model;
    }

    @RequestMapping("/user/toupdate")
    public ModelAndView toUpdate(@RequestParam(value = "userId") int userId) {
        ModelAndView mv = new ModelAndView("/user/s_editor");
        UserEntity userEntity = this.userService.findUserById(userId);
        mv.addObject("userEntity", userEntity);
        return mv;
    }


    @ResponseBody
    @RequestMapping(value = "/user/delete")
    public int delete(int id){
        return this.userService.deleteUserById(id);
    }
}