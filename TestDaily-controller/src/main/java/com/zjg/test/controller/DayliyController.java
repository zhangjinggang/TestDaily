package com.zjg.test.controller;

import com.zjg.dao.model.DeviceDO;
import com.zjg.dao.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zjg
 * @description:
 * @date 2020/11/23 17:12
 */
@RestController
@RequestMapping("dayliy")
public class DayliyController {


    @Autowired
    DeviceRepository deviceRepository;

    @RequestMapping("testDataBaseRollBack")
    public String testDataBaseRollBack(){
        DeviceDO deviceDO = new DeviceDO();
        deviceDO.setAuthCode("11111111111111");
        deviceRepository.addDevice(deviceDO);
        return "success";
    }
}
