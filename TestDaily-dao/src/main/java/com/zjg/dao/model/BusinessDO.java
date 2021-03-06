package com.zjg.dao.model;

import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table business
 */
public class BusinessDO {
    /**
     * Database Column Remarks:
     *   主键id
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.work_date
     *
     * @mbg.generated
     */
    private String workDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.operator_id
     *
     * @mbg.generated
     */
    private String operatorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.operator_code
     *
     * @mbg.generated
     */
    private String operatorCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.operator_name
     *
     * @mbg.generated
     */
    private String operatorName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.start_time
     *
     * @mbg.generated
     */
    private Long startTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.end_time
     *
     * @mbg.generated
     */
    private Long endTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.status
     *
     * @mbg.generated
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.pos_id
     *
     * @mbg.generated
     */
    private String posId;

    /**
     * Database Column Remarks:
     *   同步状态（00-初始，10开, 11全完成）
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column business.sync_state
     *
     * @mbg.generated
     */
    private String syncState;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.id
     *
     * @return the value of business.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.id
     *
     * @param id the value for business.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.gmt_create
     *
     * @return the value of business.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.gmt_create
     *
     * @param gmtCreate the value for business.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.gmt_modified
     *
     * @return the value of business.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.gmt_modified
     *
     * @param gmtModified the value for business.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.work_date
     *
     * @return the value of business.work_date
     *
     * @mbg.generated
     */
    public String getWorkDate() {
        return workDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.work_date
     *
     * @param workDate the value for business.work_date
     *
     * @mbg.generated
     */
    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.operator_id
     *
     * @return the value of business.operator_id
     *
     * @mbg.generated
     */
    public String getOperatorId() {
        return operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.operator_id
     *
     * @param operatorId the value for business.operator_id
     *
     * @mbg.generated
     */
    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.operator_code
     *
     * @return the value of business.operator_code
     *
     * @mbg.generated
     */
    public String getOperatorCode() {
        return operatorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.operator_code
     *
     * @param operatorCode the value for business.operator_code
     *
     * @mbg.generated
     */
    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.operator_name
     *
     * @return the value of business.operator_name
     *
     * @mbg.generated
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.operator_name
     *
     * @param operatorName the value for business.operator_name
     *
     * @mbg.generated
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.start_time
     *
     * @return the value of business.start_time
     *
     * @mbg.generated
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.start_time
     *
     * @param startTime the value for business.start_time
     *
     * @mbg.generated
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.end_time
     *
     * @return the value of business.end_time
     *
     * @mbg.generated
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.end_time
     *
     * @param endTime the value for business.end_time
     *
     * @mbg.generated
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.status
     *
     * @return the value of business.status
     *
     * @mbg.generated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.status
     *
     * @param status the value for business.status
     *
     * @mbg.generated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.pos_id
     *
     * @return the value of business.pos_id
     *
     * @mbg.generated
     */
    public String getPosId() {
        return posId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.pos_id
     *
     * @param posId the value for business.pos_id
     *
     * @mbg.generated
     */
    public void setPosId(String posId) {
        this.posId = posId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column business.sync_state
     *
     * @return the value of business.sync_state
     *
     * @mbg.generated
     */
    public String getSyncState() {
        return syncState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column business.sync_state
     *
     * @param syncState the value for business.sync_state
     *
     * @mbg.generated
     */
    public void setSyncState(String syncState) {
        this.syncState = syncState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", workDate=").append(workDate);
        sb.append(", operatorId=").append(operatorId);
        sb.append(", operatorCode=").append(operatorCode);
        sb.append(", operatorName=").append(operatorName);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", status=").append(status);
        sb.append(", posId=").append(posId);
        sb.append(", syncState=").append(syncState);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table business
     *
     * @mbg.generated
     */
    public static BusinessDO.Builder builder() {
        return new BusinessDO.Builder();
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table business
     *
     * @mbg.generated
     */
    public static class Builder {
        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table business
         *
         * @mbg.generated
         */
        private BusinessDO obj;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table business
         *
         * @mbg.generated
         */
        public Builder() {
            this.obj = new BusinessDO();
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.id
         *
         * @param id the value for business.id
         *
         * @mbg.generated
         */
        public Builder id(Integer id) {
            obj.setId(id);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.gmt_create
         *
         * @param gmtCreate the value for business.gmt_create
         *
         * @mbg.generated
         */
        public Builder gmtCreate(Date gmtCreate) {
            obj.setGmtCreate(gmtCreate);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.gmt_modified
         *
         * @param gmtModified the value for business.gmt_modified
         *
         * @mbg.generated
         */
        public Builder gmtModified(Date gmtModified) {
            obj.setGmtModified(gmtModified);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.work_date
         *
         * @param workDate the value for business.work_date
         *
         * @mbg.generated
         */
        public Builder workDate(String workDate) {
            obj.setWorkDate(workDate);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.operator_id
         *
         * @param operatorId the value for business.operator_id
         *
         * @mbg.generated
         */
        public Builder operatorId(String operatorId) {
            obj.setOperatorId(operatorId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.operator_code
         *
         * @param operatorCode the value for business.operator_code
         *
         * @mbg.generated
         */
        public Builder operatorCode(String operatorCode) {
            obj.setOperatorCode(operatorCode);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.operator_name
         *
         * @param operatorName the value for business.operator_name
         *
         * @mbg.generated
         */
        public Builder operatorName(String operatorName) {
            obj.setOperatorName(operatorName);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.start_time
         *
         * @param startTime the value for business.start_time
         *
         * @mbg.generated
         */
        public Builder startTime(Long startTime) {
            obj.setStartTime(startTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.end_time
         *
         * @param endTime the value for business.end_time
         *
         * @mbg.generated
         */
        public Builder endTime(Long endTime) {
            obj.setEndTime(endTime);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.status
         *
         * @param status the value for business.status
         *
         * @mbg.generated
         */
        public Builder status(String status) {
            obj.setStatus(status);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.pos_id
         *
         * @param posId the value for business.pos_id
         *
         * @mbg.generated
         */
        public Builder posId(String posId) {
            obj.setPosId(posId);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method sets the value of the database column business.sync_state
         *
         * @param syncState the value for business.sync_state
         *
         * @mbg.generated
         */
        public Builder syncState(String syncState) {
            obj.setSyncState(syncState);
            return this;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table business
         *
         * @mbg.generated
         */
        public BusinessDO build() {
            return this.obj;
        }
    }
}