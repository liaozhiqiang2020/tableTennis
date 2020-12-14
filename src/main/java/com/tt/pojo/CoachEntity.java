package com.tt.pojo;

import javax.persistence.*;

/**
 * 教练实体类
 */
@Entity
@Table(name = "tt_coach", schema = "tt", catalog = "")
public class CoachEntity {
    private int id;
    private String name;//名字
    private String idCard;//身份证号
    private String remarks;//简单描述
    private String entryDate;//入职日期
    private String leaveDate;//离职日期
    private String tel;//联系电话
    private String isFullTime;//是否全职 0 全职  1兼职
    private int placeId;//上班地点
    private String onWork;//是否在职 0 在职  1 离职
    private String onLeave;//是否请假  0在岗  1请假
    private String imgUrl;

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
    @Column(name = "id_card")
    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    @Basic
    @Column(name = "entry_date")
    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    @Basic
    @Column(name = "leave_date")
    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
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
    @Column(name = "is_full_time")
    public String getIsFullTime() {
        return isFullTime;
    }

    public void setIsFullTime(String isFullTime) {
        this.isFullTime = isFullTime;
    }

    @Basic
    @Column(name = "place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    @Basic
    @Column(name = "on_work")
    public String getOnWork() {
        return onWork;
    }

    public void setOnWork(String onWork) {
        this.onWork = onWork;
    }

    @Basic
    @Column(name = "on_leave")
    public String getOnLeave() {
        return onLeave;
    }

    public void setOnLeave(String onLeave) {
        this.onLeave = onLeave;
    }

    @Basic
    @Column(name = "img_url")
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
