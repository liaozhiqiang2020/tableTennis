package com.tt.pojo;

import javax.persistence.*;

/**
 * 通知公告实体类
 */
@Entity
@Table(name = "tt_notice", schema = "tt", catalog = "")
public class NoticeEntity {
    private int id;
    private String nickName;//标题
    private String imgUrl;//图片路径
    private String reward;//内容
    private String type;//0 通知  1公告  2消息
    private int publishId;//发布人
    private String publishDate;//发布时间
    //private int receiveId;//接收人

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
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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
    @Column(name = "reward")
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "publish_date")
    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Basic
    @Column(name = "publish_id")
    public int getPublishId() {
        return publishId;
    }

    public void setPublishId(int publishId) {
        this.publishId = publishId;
    }

//    @Basic
//    @Column(name = "receive_id")
//    public int getReceiveId() {
//        return receiveId;
//    }
//
//    public void setReceiveId(int receiveId) {
//        this.receiveId = receiveId;
//    }
}
