package com.tt.pojo;

import javax.persistence.*;

/**
 * 学员实体类
 */
@Entity
@Table(name = "tt_student", schema = "tt", catalog = "")
public class StudentEntity {
    private int id;
    private String name;
    private String age;
    private String address;//家庭地址
    private String parentName;
    private String parentTel;
    private String tel;
    private String registrTime;//报名时间
    private String placeId;//授课场地
    private String sn;//学号
    private String classHours;//剩余课时数
    private String idCard;//身份证号
    private String money;//剩余金额
    private String saleName;//销售名称
    private String unitPrice;//单节价格

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "age")
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "parent_name")
    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Basic
    @Column(name = "parent_tel")
    public String getParentTel() {
        return parentTel;
    }

    public void setParentTel(String parentTel) {
        this.parentTel = parentTel;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "registr_time")
    public String getRegistrTime() {
        return registrTime;
    }

    public void setRegistrTime(String registrTime) {
        this.registrTime = registrTime;
    }

    @Basic
    @Column(name = "place_id")
    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "sn")
    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    @Basic
    @Column(name = "class_hours")
    public String getClassHours() {
        return classHours;
    }

    public void setClassHours(String classHours) {
        this.classHours = classHours;
    }

    @Basic
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "money")
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Basic
    @Column(name = "sale_name")
    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    @Basic
    @Column(name = "unit_price")
    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }
}
