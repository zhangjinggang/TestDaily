package com.zjg.dao.repository;

import com.zjg.dao.mapper.DeviceDAO;
import com.zjg.dao.model.DeviceDO;
import com.zjg.test.util.exception.CommonBizException;
import com.zjg.test.util.exception.CommonErrorCode;
import com.zjg.test.util.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This class was generated by MyBatis Generator
 * @author Thinkpad
 */
@Repository
@Transactional(rollbackFor = Exception.class)
public class DeviceRepository {
    @Autowired
    private DeviceDAO deviceDAO;

    public void addDevice(DeviceDO deviceDO){
        deviceDAO.insert(deviceDO);
        if(true){
            throw new CommonBizException(CommonErrorCode.ILLEGAL_PARAMETERS);
        }

    }
}