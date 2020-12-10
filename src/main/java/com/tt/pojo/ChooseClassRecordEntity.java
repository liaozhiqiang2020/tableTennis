package com.tt.pojo;

import javax.persistence.*;

/**
 *选课记录实体
 */
@Entity
@Table(name = "tt_choose_class_record", schema = "tt", catalog = "")
public class ChooseClassRecordEntity {
    private int id;
    private String placeId;//场地id
    private String studentId;//学员id
    private String classContent;//选课内容
    private int expectCount;//预计每周上课节数

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
    @Column(name = "place_id")
    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "student_id")
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "class_content")
    public String getClassContent() {
        return classContent;
    }

    public void setClassContent(String classContent) {
        this.classContent = classContent;
    }

    @Basic
    @Column(name = "expect_count")
    public int getExpectCount() {
        return expectCount;
    }

    public void setExpectCount(int expectCount) {
        this.expectCount = expectCount;
    }
}
