package com.zjg.test.controller;

import com.zjg.test.service.DynamicTestService;
import com.zjg.test.service.DynamicTransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjg
 * @description:
 * @date 2021/2/20 15:46
 */
@RestController
@RequestMapping("dynamic")
public class DynamicDataSourceTestController {

    @Autowired
    DynamicTestService dynamicTestService;
    @Autowired
    DynamicTransactionTestService dynamicTransactionTestService;

    /**
     * 验证多数据源是否成功
     * @return
     */
    @RequestMapping("testInsert")
    public String testInsert(){
        dynamicTestService.insertPickup();
        dynamicTestService.insertUser();
        return "success";
    }

    /**
     * 验证@Transactional中使用线程池起异步线程
     * @return
     */
    @RequestMapping("async")
    public String async(){
        dynamicTransactionTestService.async();
        return "success";
    }


}
