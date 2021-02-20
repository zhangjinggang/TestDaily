package com.zjg.test.service.impl;

import com.zjg.dao.config.DataSource;
import com.zjg.dao.mapper.PickUpCallSettingDAO;
import com.zjg.dao.mapper.UserDAO;
import com.zjg.dao.model.PickUpCallSettingDO;
import com.zjg.dao.model.UserDO;
import com.zjg.test.service.DynamicTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zjg
 * @description:
 * @date 2021/2/20 15:50
 */
@Service
public class DynamicTestServiceImpl implements DynamicTestService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    PickUpCallSettingDAO pickUpCallSettingDAO;

    @Override
    @DataSource("twoDataSource")
    public void insertUser() {
        UserDO record = new UserDO();
        record.setId(1);
        record.setAge(1);
        record.setName("1");
        userDAO.insert(record);
    }

    @Override
//    @DataSource("oneDataSource")
    public void insertPickup() {
        PickUpCallSettingDO record = new PickUpCallSettingDO();
        record.setId(124321L);
        record.setBrandIdenty(1L);
        pickUpCallSettingDAO.insertSelective(record);
    }


}
