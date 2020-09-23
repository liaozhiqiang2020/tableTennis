package com.tt.service.impl;

import com.tt.pojo.PermissionEntity;
import com.tt.pojo.RoleEntity;
import com.tt.pojo.UserEntity;
import com.tt.repository.PermissionRepository;
import com.tt.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
/**
 * 登陆处理
 */
public class MyUserDetailService implements UserDetailsService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private PermissionRepository permissionRepository;

    //登陆验证时，通过username获取用户的所有权限信息，
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
    public UserDetails loadUserByUsername(String username) {
        UserEntity user = userRepository.findUserByUserName(username);
        Set<PermissionEntity> permissions = new HashSet<>();
        if (user != null) {
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            Set<RoleEntity> roleEntities =  user.getRoleEntitySet();
            for (RoleEntity roleEntity : roleEntities){
                Set<PermissionEntity> permission = roleEntity.getPermissionEntityHashSet();
                permissions.addAll(permission);
            }

            for (PermissionEntity permission : permissions) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermissionsName());
                grantedAuthorities.add(grantedAuthority);
            }
            return new User(user.getUserName(), user.getAuthenticationString(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("admin: " + username + " do not exist!");
        }
    }

    /**
     * 获取登录用户IP地址
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "本地";
        }
        return ip;
    }
}

