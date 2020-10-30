package com.zjg.test.service;

/**
 * @author zjg
 * @description:
 * @date 2020/10/30 10:10
 */

public interface RedisTestService {

    void setKey(String key,String value);

    String getValue(String key);
}
