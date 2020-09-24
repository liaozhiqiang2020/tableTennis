package com.tt.pojo;

import javax.persistence.*;

/**
 * 学生签到信息表
 */
@Entity
@Table(name = "tt_student_sign", schema = "tt", catalog = "")
public class StudentSignEntity {
    private int id;
    private String signTime;//签到时间
    private int studentId;//签到学生
    private int teacher;//负责老师

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
    @Column(name = "signTime")
    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    @Basic
    @Column(name = "studentId")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "teacher")
    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }
}
