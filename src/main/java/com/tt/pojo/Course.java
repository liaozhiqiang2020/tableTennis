package com.tt.pojo;

import javax.persistence.*;

/**
 * 课程实体类
 */
@Entity
@Table(name = "tt_course", schema = "tt", catalog = "")
public class Course {
    private int id;
    private String name;
    private int type;//1.社团(免费)  2.社团(收费)  3.收费培训(基础)  4.收费培训(高级)
    private int inSchool;//1.校内  2.校外
    private int classHours; //课时数
    private String money;//单节课时费

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
    @Column(name = "type")
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Basic
    @Column(name = "inSchool")
    public int getInSchool() {
        return inSchool;
    }

    public void setInSchool(int inSchool) {
        this.inSchool = inSchool;
    }

    @Basic
    @Column(name = "classHours")
    public int getClassHours() {
        return classHours;
    }

    public void setClassHours(int classHours) {
        this.classHours = classHours;
    }

    @Basic
    @Column(name = "money")
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
