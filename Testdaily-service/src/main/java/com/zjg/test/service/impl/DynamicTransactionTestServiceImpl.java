package com.zjg.test.service.impl;

import com.zjg.test.service.DynamicTestService;
import com.zjg.test.service.DynamicTransactionTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zjg
 * @description:
 * @date 2021/2/20 16:44
 */
@Service
public class DynamicTransactionTestServiceImpl implements DynamicTransactionTestService {

    @Autowired
    DynamicTestService dynamicTestService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void async() {
//        dynamicTestService.insertUser();
        dynamicTestService.insertPickup();

    }
}
