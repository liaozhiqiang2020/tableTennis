package com.tt.pojo;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *  设备类
 */
@Entity
@Table(name = "mc_device", schema = "mc", catalog = "")
public class DeviceEntity {
    /**
     * 主键Id
     */
    private int id;
    /**
     * 维修时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Timestamp maintainDateTime;
    /**
     * 按摩椅纬度
     */
    private BigDecimal latitude;
    /**
     * 按摩椅经度
     */
    private BigDecimal longitude;
    /**
     * 按摩椅状态(0可用,1使用中,2维修中)
     */
    private int mcStatus;
    /**
     * 按摩椅是否在线
     */
    private int mcIsNotOnline;
    /**
     * 按摩椅sn
     */
    private String mcSn;
    /**
     * 按摩椅模块编号
     */
    private String loraId;
    /**
     * 备注
     */
    private String note;
    /**
     * 按摩强度(0弱,1中,2强)
     */
    private int strength;
    /**
     * 删除状态
     */
    private Integer discardStatus;

    /**
     * 场地
     */
    private int placeId;

    /**
     * 设备最后在线时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    /**
     * 设备最后在线时间
     */
    private Timestamp lastCorrespondTime;
//    private int offlineTime;//设备离线时长

    @Id
    @GeneratedValue
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   /* @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(value = {org.hibernate.annotations.CascadeType.ALL})
    @JoinTable(name = "mc_price_device",                       //指定第三张表
            joinColumns = {@JoinColumn(name = "device_id")},             //本表与中间表的外键对应
            inverseJoinColumns = {@JoinColumn(name = "price_id")})  //另一张表与第三张表的外键的对应关系
    @JsonIgnore
    public List<PriceEntity> getPriceEntities() {
        return priceEntities;
    }

    public void setPriceEntities(List<PriceEntity> priceEntities) {
        this.priceEntities = priceEntities;
    }*/

    @Basic
    @Column(name = "last_correspond_time")
    public Timestamp getLastCorrespondTime() {
        return lastCorrespondTime;
    }

    public void setLastCorrespondTime(Timestamp lastCorrespondTime) {
        this.lastCorrespondTime = lastCorrespondTime;
    }


    @Basic
    @Column(name = "isnot_online")
    public int getMcIsNotOnline() {
        return mcIsNotOnline;
    }

    public void setMcIsNotOnline(int mcIsNotOnline) {
        this.mcIsNotOnline = mcIsNotOnline;
    }

    @Basic
    @Column(name = "strength")
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Basic
    @Column(name="place_id")
    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

   /* @ManyToOne
    @JoinColumn(name="gateway_id")
    public GatewayEntity getGatewayEntity() {
        return gatewayEntity;
    }

    public void setGatewayEntity(GatewayEntity gatewayEntity) {
        this.gatewayEntity = gatewayEntity;
    }*/

    @Basic
    @Column(name = "loraId")
    public String getLoraId() {
        return loraId;
    }

    public void setLoraId(String loraId) {
        this.loraId = loraId;
    }

    @Basic
    @Column(name = "maintain_date_time")
    public Timestamp getMaintainDateTime() {
        return maintainDateTime;
    }

    public void setMaintainDateTime(Timestamp maintainDateTime) {
        this.maintainDateTime = maintainDateTime;
    }

    @Basic
    @Column(name = "latitude")
    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "longitude")
    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }


    @Basic
    @Column(name = "mc_status")
    public int getMcStatus() {
        return mcStatus;
    }

    public void setMcStatus(int mcStatus) {
        this.mcStatus = mcStatus;
    }

    @Basic
    @Column(name = "mc_sn")
    public String getMcSn() {
        return mcSn;
    }

    public void setMcSn(String mcSn) {
        this.mcSn = mcSn;
    }

    @Basic
    @Column(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Basic
    @Column(name = "discard_status")
    public Integer getDiscardStatus() {
        return discardStatus;
    }

    public void setDiscardStatus(Integer discardStatus) {
        this.discardStatus = discardStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceEntity that = (DeviceEntity) o;
        return id == that.id &&
                mcStatus == that.mcStatus &&
                Objects.equals(maintainDateTime, that.maintainDateTime) &&
                Objects.equals(latitude, that.latitude) &&
                Objects.equals(longitude, that.longitude) &&
                Objects.equals(mcSn, that.mcSn) &&
                Objects.equals(note, that.note) &&
                Objects.equals(discardStatus, that.discardStatus);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, maintainDateTime, latitude, longitude, mcStatus, mcSn, note, discardStatus);
    }


}
