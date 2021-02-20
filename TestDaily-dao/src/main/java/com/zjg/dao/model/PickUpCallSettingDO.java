package com.zjg.dao.model;

import java.io.Serializable;
import java.util.Date;

/**
 * pick_up_call_setting
 * @author 
 */
public class PickUpCallSettingDO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 品牌id
     */
    private Long brandIdenty;

    /**
     * 商户id
     */
    private Long shopIdenty;

    /**
     * 语音播报次数
     */
    private Integer voiceAnnounceNum;

    /**
     * 取餐处  1:出餐口  2:取餐口  3:收银台
     */
    private Integer pickUpMealPlace;

    /**
     * 通知方式  1:pos语音播报  2:IVR电话通知  3:CDS语音播报  4:小程序通知
     */
    private String notifyType;

    /**
     * 是否启用超时自动取餐设置 0:不启用  1:启用
     */
    private Byte expireAutoPickUpEnable;

    /**
     * 自动已取餐时间，取餐时间超时后将自动变为已取餐,单位秒
     */
    private Long expireAutoPickUpSeconds;

    /**
     * 服务器创建时间
     */
    private Date serverCreateTime;

    /**
     * 服务器更新时间
     */
    private Date serverUpdateTime;

    /**
     * 是否逻辑删除 0:未删除  1:已删除  
     */
    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandIdenty() {
        return brandIdenty;
    }

    public void setBrandIdenty(Long brandIdenty) {
        this.brandIdenty = brandIdenty;
    }

    public Long getShopIdenty() {
        return shopIdenty;
    }

    public void setShopIdenty(Long shopIdenty) {
        this.shopIdenty = shopIdenty;
    }

    public Integer getVoiceAnnounceNum() {
        return voiceAnnounceNum;
    }

    public void setVoiceAnnounceNum(Integer voiceAnnounceNum) {
        this.voiceAnnounceNum = voiceAnnounceNum;
    }

    public Integer getPickUpMealPlace() {
        return pickUpMealPlace;
    }

    public void setPickUpMealPlace(Integer pickUpMealPlace) {
        this.pickUpMealPlace = pickUpMealPlace;
    }

    public String getNotifyType() {
        return notifyType;
    }

    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public Byte getExpireAutoPickUpEnable() {
        return expireAutoPickUpEnable;
    }

    public void setExpireAutoPickUpEnable(Byte expireAutoPickUpEnable) {
        this.expireAutoPickUpEnable = expireAutoPickUpEnable;
    }

    public Long getExpireAutoPickUpSeconds() {
        return expireAutoPickUpSeconds;
    }

    public void setExpireAutoPickUpSeconds(Long expireAutoPickUpSeconds) {
        this.expireAutoPickUpSeconds = expireAutoPickUpSeconds;
    }

    public Date getServerCreateTime() {
        return serverCreateTime;
    }

    public void setServerCreateTime(Date serverCreateTime) {
        this.serverCreateTime = serverCreateTime;
    }

    public Date getServerUpdateTime() {
        return serverUpdateTime;
    }

    public void setServerUpdateTime(Date serverUpdateTime) {
        this.serverUpdateTime = serverUpdateTime;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PickUpCallSettingDO other = (PickUpCallSettingDO) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getBrandIdenty() == null ? other.getBrandIdenty() == null : this.getBrandIdenty().equals(other.getBrandIdenty()))
            && (this.getShopIdenty() == null ? other.getShopIdenty() == null : this.getShopIdenty().equals(other.getShopIdenty()))
            && (this.getVoiceAnnounceNum() == null ? other.getVoiceAnnounceNum() == null : this.getVoiceAnnounceNum().equals(other.getVoiceAnnounceNum()))
            && (this.getPickUpMealPlace() == null ? other.getPickUpMealPlace() == null : this.getPickUpMealPlace().equals(other.getPickUpMealPlace()))
            && (this.getNotifyType() == null ? other.getNotifyType() == null : this.getNotifyType().equals(other.getNotifyType()))
            && (this.getExpireAutoPickUpEnable() == null ? other.getExpireAutoPickUpEnable() == null : this.getExpireAutoPickUpEnable().equals(other.getExpireAutoPickUpEnable()))
            && (this.getExpireAutoPickUpSeconds() == null ? other.getExpireAutoPickUpSeconds() == null : this.getExpireAutoPickUpSeconds().equals(other.getExpireAutoPickUpSeconds()))
            && (this.getServerCreateTime() == null ? other.getServerCreateTime() == null : this.getServerCreateTime().equals(other.getServerCreateTime()))
            && (this.getServerUpdateTime() == null ? other.getServerUpdateTime() == null : this.getServerUpdateTime().equals(other.getServerUpdateTime()))
            && (this.getDeleteFlag() == null ? other.getDeleteFlag() == null : this.getDeleteFlag().equals(other.getDeleteFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getBrandIdenty() == null) ? 0 : getBrandIdenty().hashCode());
        result = prime * result + ((getShopIdenty() == null) ? 0 : getShopIdenty().hashCode());
        result = prime * result + ((getVoiceAnnounceNum() == null) ? 0 : getVoiceAnnounceNum().hashCode());
        result = prime * result + ((getPickUpMealPlace() == null) ? 0 : getPickUpMealPlace().hashCode());
        result = prime * result + ((getNotifyType() == null) ? 0 : getNotifyType().hashCode());
        result = prime * result + ((getExpireAutoPickUpEnable() == null) ? 0 : getExpireAutoPickUpEnable().hashCode());
        result = prime * result + ((getExpireAutoPickUpSeconds() == null) ? 0 : getExpireAutoPickUpSeconds().hashCode());
        result = prime * result + ((getServerCreateTime() == null) ? 0 : getServerCreateTime().hashCode());
        result = prime * result + ((getServerUpdateTime() == null) ? 0 : getServerUpdateTime().hashCode());
        result = prime * result + ((getDeleteFlag() == null) ? 0 : getDeleteFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", brandIdenty=").append(brandIdenty);
        sb.append(", shopIdenty=").append(shopIdenty);
        sb.append(", voiceAnnounceNum=").append(voiceAnnounceNum);
        sb.append(", pickUpMealPlace=").append(pickUpMealPlace);
        sb.append(", notifyType=").append(notifyType);
        sb.append(", expireAutoPickUpEnable=").append(expireAutoPickUpEnable);
        sb.append(", expireAutoPickUpSeconds=").append(expireAutoPickUpSeconds);
        sb.append(", serverCreateTime=").append(serverCreateTime);
        sb.append(", serverUpdateTime=").append(serverUpdateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}