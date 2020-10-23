package com.zjg.test.compare.compare;


import java.io.Serializable;

/**
 * @program: bill-manage
 * @description: 支付信息配置表
 * @author: 陈际栋
 * @create: 2019-03-23
 **/
public class OnlinePayConfig implements Serializable {
    private static final long serialVersionUID = 457473463665595787L;
    //主键
    private String id;
    //商户ID
    private String tenantId;
    //门店编码
    private String storeId;
    //支付编码
    private String payCode;
    //三方支付编码
    private String threePayCode;
    //支付类型
    private Integer payType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getPayCode() {
        return payCode;
    }

    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    public String getThreePayCode() {
        return threePayCode;
    }

    public void setThreePayCode(String threePayCode) {
        this.threePayCode = threePayCode;
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "OnlinePayConfig{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", payCode='" + payCode + '\'' +
                ", threePayCode='" + threePayCode + '\'' +
                ", payType=" + payType +
                '}';
    }
}

