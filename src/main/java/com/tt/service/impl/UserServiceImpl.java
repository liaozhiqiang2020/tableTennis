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

    @Resource
    RoleRepository roleRepository;

    /**
     * 分页查询所有用户
     * @param page 起始个数
     * @param pageSize 截至个数
     * @return 用户信息
     */
    @Override
    @Transactional
    public String findEntitiesPager(int page, int pageSize) {
        int offset = ((page - 1) * pageSize);
        int total = this.userRepository.findPriceTotal();
        List<UserEntity> userList = this.userRepository.findAllUserByPage(offset, pageSize);
        String company = "";
        String pName = "";
        JsonConfig config = new JsonConfig();
        config.registerJsonValueProcessor(Timestamp.class, new DateJsonValueProcessor("yyyy-MM-dd HH:mm:ss"));
        config.setExcludes(new String[]{"roleEntitySet"});//红色的部分是过滤掉deviceEntities对象 不转成JSONArray
//        config.setIgnoreDefaultExcludes(false);  //设置默认忽略
//        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        JSONArray jsonArray = JSONArray.fromObject(userList, config);//转化为jsonArray
        JSONArray jsonArray1 = new JSONArray();//新建json数组
        JSONObject jsonObject = new JSONObject();

        for (int y = 0; y < jsonArray.size(); y++) {
            JSONObject jsonObject2 = jsonArray.getJSONObject(y);
            company="总公司";
            pName="总公司";
            jsonObject2.put("company", company);
            jsonObject2.put("pName", pName);
            jsonArray1.add(jsonObject2);
        }
        jsonObject.put("data", jsonArray1);
        jsonObject.put("total", total);
        return jsonObject.toString();
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

    /**
     * 更新用户
     * @param map user对象
     * @return 修改的个数
     */
    @Override
    @Transactional
    public int updateUser(Map<String, Object> map) {
        String company = (String) map.get("company");
        String password = (String) map.get("authenticationString");
        String cellphoneNumber = (String) map.get("cellphoneNumber");
        String email = (String) map.get("email");
        int id = (int) map.get("id");
        String fixedPhoneNumber = (String) map.get("fixedPhoneNumber");
        String latestLoginIp = (String) map.get("latestLoginIp");
        String name = (String) map.get("name");
        String userName = (String) map.get("userName");
        int status = (int) map.get("status");
        String createDateTime = (String) map.get("createDatetime");
//        String latestLoginDatetime = (String) map.get("latestLoginDatetime");
//        String lastTime = intUtil.dateString(latestLoginDatetime);
        UserEntity user = this.userRepository.findUserById(id);
        UserEntity ss = this.userRepository.findUserByUserName(userName);
        if ( ss==user||ss == null ){
            user.setStatus(status);
            user.setCellphoneNumber(cellphoneNumber);
            user.setEmail(email);
            user.setFixedPhoneNumber(fixedPhoneNumber);
            user.setName(name);
            user.setUserName(userName);
            user.setLatestLoginIp(latestLoginIp);
//        user.setLatestLoginDatetime(Timestamp.valueOf(lastTime));
//        user.setAuthenticationString(DigestUtils.md5DigestAsHex(password.getBytes()));
            if (password.length() == 32){
                user.setAuthenticationString(password);
            }else {
                user.setAuthenticationString(MD5Util.encode(password));
            }


            this.userRepository.save(user);
            return 1;
        }else {

        return 0;
        }
    }

    /**
     * 新建一个用户
     * @param map user对象
     * @return 新建的个数
     */
    @Override
    @Transactional
    public int saveUser(@RequestBody Map<String, Object> map) {
        String company = (String) map.get("company");
        String password = (String) map.get("authenticationString");
        String cellphoneNumber = (String) map.get("cellphoneNumber");
        String email = (String) map.get("email");
        String fixedPhoneNumber = (String) map.get("fixedPhoneNumber");
        String latestLoginIp = (String) map.get("latestLoginIp");
        String name = (String) map.get("name");
        String userName = (String) map.get("userName");
        int status = 1;
        String latestLoginDatetime = (String) map.get("latestLoginDatetime");

        int ss = this.userRepository.findUserName(userName);
        if (ss == 1 ){
            return 0;
        }else {

            UserEntity user = new UserEntity();
            user.setStatus(status);
            user.setCellphoneNumber(cellphoneNumber);
            user.setEmail(email);
            user.setFixedPhoneNumber(fixedPhoneNumber);
            user.setName(name);
            user.setUserName(userName);
            user.setLatestLoginIp(latestLoginIp);
            user.setCreateDatetime(new Timestamp(System.currentTimeMillis()));

            user.setAuthenticationString(MD5Util.encode(password));

            this.userRepository.save(user);
            return 1;
        }
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

    /**
     * 查询当前用户拥有的所有角色
     * @param userId 用户ID
     * @return 角色信息
     */
    @Override
    public Set<RoleEntity> findUserRole(int userId) {
        UserEntity user = this.userRepository.findUserById(userId);
        return user.getRoleEntitySet();
    }

    /**
     * 解绑用户所拥有的角色
     * @param listMap  用户id 权限Id
     * @return 用户权限
     */
    @Override
    public Set<RoleEntity> deleteUserRole(Map<String, Object> listMap) {
        Object userId = listMap.get("userId");
        Object roleId = listMap.get("roleId");
        UserEntity user = this.userRepository.findUserById((int) userId);

        RoleEntity role = this.roleRepository.findById((int) roleId);
        user.getRoleEntitySet().remove(role);

        this.userRepository.save(user);
        return user.getRoleEntitySet();
    }

    /**
     * 为用户绑定角色
     * @param userId 用户Id
     * @param roleId 角色id
     * @return 用户角色权限
     */
    @Override
    public Set<RoleEntity> addUserRole(int userId, int roleId) {
        UserEntity user = this.userRepository.findUserById(userId);
        RoleEntity role = this.roleRepository.findById(roleId);
        user.getRoleEntitySet().add(role);
        this.userRepository.save(user);
        return user.getRoleEntitySet();
    }

    /**
     * 删除绑定的角色
     * @param userId 用户id
     * @return 权限信息
     */
    @Override
    public List<RoleEntity> userUnRole(int userId) {
        UserEntity user = this.userRepository.findUserById(userId);
        List<RoleEntity> roleEntities = this.roleRepository.findAll();
        roleEntities.removeAll(user.getRoleEntitySet());
        return roleEntities;
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
}