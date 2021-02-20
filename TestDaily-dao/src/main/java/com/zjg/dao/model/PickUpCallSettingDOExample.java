package com.zjg.dao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PickUpCallSettingDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PickUpCallSettingDOExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyIsNull() {
            addCriterion("brand_identy is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyIsNotNull() {
            addCriterion("brand_identy is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyEqualTo(Long value) {
            addCriterion("brand_identy =", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyNotEqualTo(Long value) {
            addCriterion("brand_identy <>", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyGreaterThan(Long value) {
            addCriterion("brand_identy >", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyGreaterThanOrEqualTo(Long value) {
            addCriterion("brand_identy >=", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyLessThan(Long value) {
            addCriterion("brand_identy <", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyLessThanOrEqualTo(Long value) {
            addCriterion("brand_identy <=", value, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyIn(List<Long> values) {
            addCriterion("brand_identy in", values, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyNotIn(List<Long> values) {
            addCriterion("brand_identy not in", values, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyBetween(Long value1, Long value2) {
            addCriterion("brand_identy between", value1, value2, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andBrandIdentyNotBetween(Long value1, Long value2) {
            addCriterion("brand_identy not between", value1, value2, "brandIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyIsNull() {
            addCriterion("shop_identy is null");
            return (Criteria) this;
        }

        public Criteria andShopIdentyIsNotNull() {
            addCriterion("shop_identy is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdentyEqualTo(Long value) {
            addCriterion("shop_identy =", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyNotEqualTo(Long value) {
            addCriterion("shop_identy <>", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyGreaterThan(Long value) {
            addCriterion("shop_identy >", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_identy >=", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyLessThan(Long value) {
            addCriterion("shop_identy <", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyLessThanOrEqualTo(Long value) {
            addCriterion("shop_identy <=", value, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyIn(List<Long> values) {
            addCriterion("shop_identy in", values, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyNotIn(List<Long> values) {
            addCriterion("shop_identy not in", values, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyBetween(Long value1, Long value2) {
            addCriterion("shop_identy between", value1, value2, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andShopIdentyNotBetween(Long value1, Long value2) {
            addCriterion("shop_identy not between", value1, value2, "shopIdenty");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumIsNull() {
            addCriterion("voice_announce_num is null");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumIsNotNull() {
            addCriterion("voice_announce_num is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumEqualTo(Integer value) {
            addCriterion("voice_announce_num =", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumNotEqualTo(Integer value) {
            addCriterion("voice_announce_num <>", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumGreaterThan(Integer value) {
            addCriterion("voice_announce_num >", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("voice_announce_num >=", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumLessThan(Integer value) {
            addCriterion("voice_announce_num <", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumLessThanOrEqualTo(Integer value) {
            addCriterion("voice_announce_num <=", value, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumIn(List<Integer> values) {
            addCriterion("voice_announce_num in", values, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumNotIn(List<Integer> values) {
            addCriterion("voice_announce_num not in", values, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumBetween(Integer value1, Integer value2) {
            addCriterion("voice_announce_num between", value1, value2, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andVoiceAnnounceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("voice_announce_num not between", value1, value2, "voiceAnnounceNum");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceIsNull() {
            addCriterion("pick_up_meal_place is null");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceIsNotNull() {
            addCriterion("pick_up_meal_place is not null");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceEqualTo(Integer value) {
            addCriterion("pick_up_meal_place =", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceNotEqualTo(Integer value) {
            addCriterion("pick_up_meal_place <>", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceGreaterThan(Integer value) {
            addCriterion("pick_up_meal_place >", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("pick_up_meal_place >=", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceLessThan(Integer value) {
            addCriterion("pick_up_meal_place <", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceLessThanOrEqualTo(Integer value) {
            addCriterion("pick_up_meal_place <=", value, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceIn(List<Integer> values) {
            addCriterion("pick_up_meal_place in", values, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceNotIn(List<Integer> values) {
            addCriterion("pick_up_meal_place not in", values, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_meal_place between", value1, value2, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andPickUpMealPlaceNotBetween(Integer value1, Integer value2) {
            addCriterion("pick_up_meal_place not between", value1, value2, "pickUpMealPlace");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNull() {
            addCriterion("notify_type is null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIsNotNull() {
            addCriterion("notify_type is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeEqualTo(String value) {
            addCriterion("notify_type =", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotEqualTo(String value) {
            addCriterion("notify_type <>", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThan(String value) {
            addCriterion("notify_type >", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeGreaterThanOrEqualTo(String value) {
            addCriterion("notify_type >=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThan(String value) {
            addCriterion("notify_type <", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLessThanOrEqualTo(String value) {
            addCriterion("notify_type <=", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeLike(String value) {
            addCriterion("notify_type like", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotLike(String value) {
            addCriterion("notify_type not like", value, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeIn(List<String> values) {
            addCriterion("notify_type in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotIn(List<String> values) {
            addCriterion("notify_type not in", values, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeBetween(String value1, String value2) {
            addCriterion("notify_type between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andNotifyTypeNotBetween(String value1, String value2) {
            addCriterion("notify_type not between", value1, value2, "notifyType");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableIsNull() {
            addCriterion("expire_auto_pick_up_enable is null");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableIsNotNull() {
            addCriterion("expire_auto_pick_up_enable is not null");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableEqualTo(Byte value) {
            addCriterion("expire_auto_pick_up_enable =", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableNotEqualTo(Byte value) {
            addCriterion("expire_auto_pick_up_enable <>", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableGreaterThan(Byte value) {
            addCriterion("expire_auto_pick_up_enable >", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableGreaterThanOrEqualTo(Byte value) {
            addCriterion("expire_auto_pick_up_enable >=", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableLessThan(Byte value) {
            addCriterion("expire_auto_pick_up_enable <", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableLessThanOrEqualTo(Byte value) {
            addCriterion("expire_auto_pick_up_enable <=", value, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableIn(List<Byte> values) {
            addCriterion("expire_auto_pick_up_enable in", values, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableNotIn(List<Byte> values) {
            addCriterion("expire_auto_pick_up_enable not in", values, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableBetween(Byte value1, Byte value2) {
            addCriterion("expire_auto_pick_up_enable between", value1, value2, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpEnableNotBetween(Byte value1, Byte value2) {
            addCriterion("expire_auto_pick_up_enable not between", value1, value2, "expireAutoPickUpEnable");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsIsNull() {
            addCriterion("expire_auto_pick_up_seconds is null");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsIsNotNull() {
            addCriterion("expire_auto_pick_up_seconds is not null");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsEqualTo(Long value) {
            addCriterion("expire_auto_pick_up_seconds =", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsNotEqualTo(Long value) {
            addCriterion("expire_auto_pick_up_seconds <>", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsGreaterThan(Long value) {
            addCriterion("expire_auto_pick_up_seconds >", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsGreaterThanOrEqualTo(Long value) {
            addCriterion("expire_auto_pick_up_seconds >=", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsLessThan(Long value) {
            addCriterion("expire_auto_pick_up_seconds <", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsLessThanOrEqualTo(Long value) {
            addCriterion("expire_auto_pick_up_seconds <=", value, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsIn(List<Long> values) {
            addCriterion("expire_auto_pick_up_seconds in", values, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsNotIn(List<Long> values) {
            addCriterion("expire_auto_pick_up_seconds not in", values, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsBetween(Long value1, Long value2) {
            addCriterion("expire_auto_pick_up_seconds between", value1, value2, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andExpireAutoPickUpSecondsNotBetween(Long value1, Long value2) {
            addCriterion("expire_auto_pick_up_seconds not between", value1, value2, "expireAutoPickUpSeconds");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeIsNull() {
            addCriterion("server_create_time is null");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeIsNotNull() {
            addCriterion("server_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeEqualTo(Date value) {
            addCriterion("server_create_time =", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeNotEqualTo(Date value) {
            addCriterion("server_create_time <>", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeGreaterThan(Date value) {
            addCriterion("server_create_time >", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("server_create_time >=", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeLessThan(Date value) {
            addCriterion("server_create_time <", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("server_create_time <=", value, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeIn(List<Date> values) {
            addCriterion("server_create_time in", values, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeNotIn(List<Date> values) {
            addCriterion("server_create_time not in", values, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeBetween(Date value1, Date value2) {
            addCriterion("server_create_time between", value1, value2, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("server_create_time not between", value1, value2, "serverCreateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeIsNull() {
            addCriterion("server_update_time is null");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeIsNotNull() {
            addCriterion("server_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeEqualTo(Date value) {
            addCriterion("server_update_time =", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeNotEqualTo(Date value) {
            addCriterion("server_update_time <>", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeGreaterThan(Date value) {
            addCriterion("server_update_time >", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("server_update_time >=", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeLessThan(Date value) {
            addCriterion("server_update_time <", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("server_update_time <=", value, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeIn(List<Date> values) {
            addCriterion("server_update_time in", values, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeNotIn(List<Date> values) {
            addCriterion("server_update_time not in", values, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("server_update_time between", value1, value2, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andServerUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("server_update_time not between", value1, value2, "serverUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNull() {
            addCriterion("delete_flag is null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIsNotNull() {
            addCriterion("delete_flag is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagEqualTo(Byte value) {
            addCriterion("delete_flag =", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotEqualTo(Byte value) {
            addCriterion("delete_flag <>", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThan(Byte value) {
            addCriterion("delete_flag >", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagGreaterThanOrEqualTo(Byte value) {
            addCriterion("delete_flag >=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThan(Byte value) {
            addCriterion("delete_flag <", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagLessThanOrEqualTo(Byte value) {
            addCriterion("delete_flag <=", value, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagIn(List<Byte> values) {
            addCriterion("delete_flag in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotIn(List<Byte> values) {
            addCriterion("delete_flag not in", values, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }

        public Criteria andDeleteFlagNotBetween(Byte value1, Byte value2) {
            addCriterion("delete_flag not between", value1, value2, "deleteFlag");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}