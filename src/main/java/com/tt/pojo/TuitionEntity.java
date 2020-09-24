package com.tt.pojo;

import javax.persistence.*;

/**
 * 收费实体类
 */
@Entity
@Table(name = "tt_tuition", schema = "tt", catalog = "")
public class TuitionEntity {
    private int id;
    private String explain;//备注
    private int studentId;//学生
    private String money;//收费金额
    private int chargeType;//收费方式  1.现金  2.微信  3.支付宝
    private int invoice;//是否开票  1.已开  2.未开
    private int billingType;//开票类型 1.普通发票  2.增值税专用发票
    private String payTime;//缴费时间
    private int courseId;//绑定课程

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
    @Column(name = "explain")
    public String getExplain() {
        return explain;
    }

    public void setExplain(String explain) {
        this.explain = explain;
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
    @Column(name = "money")
    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    @Basic
    @Column(name = "chargeType")
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
    @Column(name = "billingType")
    public int getBillingType() {
        return billingType;
    }

    public void setBillingType(int billingType) {
        this.billingType = billingType;
    }

    @Basic
    @Column(name = "payTime")
    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    @Basic
    @Column(name = "courseId")
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }
}
