package com.tt.pojo;

import javax.persistence.*;

/**
 * 缴费管理
 */
@Entity
@Table(name = "tt_tuition", schema = "tt", catalog = "")
public class TuitionEntity {
    private int id;
    private int studentId;//学生
    private int placeId;
    private String payMoney;//缴费金额
    private String payTime;//缴费时间
    private int chargeType;//缴费方式  1.现金  2.微信  3.支付宝
    private int invoice;//是否开票  1.已开  2.未开
    private int billingType;//开票类型 1.普通发票  2.增值税专用发票  3.收据
    private int courseId;//绑定课程
    private String description;//备注

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
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    @Basic
    @Column(name = "pay_money")
    public String getPayMoney() {
        return payMoney;
    }

    public void setPayMoney(String payMoney) {
        this.payMoney = payMoney;
    }

    @Basic
    @Column(name = "charge_type")
    public int getChargeType() {
        return chargeType;
    }

    public void setChargeType(int chargeType) {
        this.chargeType = chargeType;
    }

    @Basic
    @Column(name = "invoice")
    public int getInvoice() {
        return invoice;
    }

    public void setInvoice(int invoice) {
        this.invoice = invoice;
    }

    @Basic
    @Column(name = "billing_type")
    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    @Basic
    @Column(name = "pay_time")
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "course_id")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }
}
