package compare.compare;


import java.io.Serializable;

public class SellOff implements Cloneable {
    private String id;
    private String tenantId;
    private String storeId;
    private String dishId;
    private String skuId;
    private String nremain;
    private String limitBeginTime;
    private String limitEndTime;

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

    public String getDishId() {
        return dishId;
    }

    public void setDishId(String dishId) {
        this.dishId = dishId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getNremain() {
        return nremain;
    }

    public void setNremain(String nremain) {
        this.nremain = nremain;
    }

    public String getLimitBeginTime() {
        return limitBeginTime;
    }

    public void setLimitBeginTime(String limitBeginTime) {
        this.limitBeginTime = limitBeginTime;
    }

    public String getLimitEndTime() {
        return limitEndTime;
    }

    public void setLimitEndTime(String limitEndTime) {
        this.limitEndTime = limitEndTime;
    }

    @Override
    protected SellOff clone() {
        try {
            SellOff result = (SellOff) super.clone();
            return result;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public String toString() {
        return "SellOff{" +
                "id='" + id + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", storeId='" + storeId + '\'' +
                ", dishId='" + dishId + '\'' +
                ", skuId='" + skuId + '\'' +
                ", nremain='" + nremain + '\'' +
                ", limitBeginTime='" + limitBeginTime + '\'' +
                ", limitEndTime='" + limitEndTime + '\'' +
                '}';
    }
}

