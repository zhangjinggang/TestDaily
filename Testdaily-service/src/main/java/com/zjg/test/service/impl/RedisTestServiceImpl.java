//package com.zjg.test.service.impl;
//
//import com.zjg.test.service.RedisTestService;
//import org.redisson.api.RedissonClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
///**
// * @author zjg
// * @description:
// * @date 2020/10/30 11:01
// */
//@Service
//public class RedisTestServiceImpl implements RedisTestService {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//    @Autowired
//    private RedissonClient redissonClient;
//
//    @Override
//    public void setKey(String key, String value) {
//        redisTemplate.opsForValue().set(key,value);
//    }
//
//    @Override
//    public String getValue(String key) {
//        return (String) redisTemplate.opsForValue().get(key);
//    }
//
//
//}
