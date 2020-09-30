package com.tt.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 用户表
 *
 * @author 魏帅志
 */
@Entity
@Table(name = "mc_user", schema = "mc", catalog = "")
public class UserEntity {
    /**
     * 主键Id
     */
    private int id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户真实姓名
     */
    private String name;
    /**
     * 密码
     */
    private String authenticationString;
    /**
     * 创建日期
     */
    private String createDatetime;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String cellphoneNumber;
    /**
     * 上次登陆时间
     */
    private String latestLoginDatetime;
    /**
     * 上次登陆id
     */
    private String latestLoginIp;
    /**
     * 状态
     */
    private int status;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_name", unique = true, nullable = false)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "authentication_string")
    public String getAuthenticationString() {
        return authenticationString;
    }

    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString;
    }



    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Basic
    @Column(name = "cellphone_number")
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    public void setCellphoneNumber(String cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }



    @Basic
    @Column(name = "create_datetime")
    public String getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(String createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Basic
    @Column(name = "latest_login_datetime")
    public String getLatestLoginDatetime() {
        return latestLoginDatetime;
    }

    public void setLatestLoginDatetime(String latestLoginDatetime) {
        this.latestLoginDatetime = latestLoginDatetime;
    }

    @Basic
    @Column(name = "latest_login_ip")
    public String getLatestLoginIp() {
        return latestLoginIp;
    }

    public void setLatestLoginIp(String latestLoginIp) {
        this.latestLoginIp = latestLoginIp;
    }


    @Basic
    @Column(name = "status")
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
