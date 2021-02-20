package com.zjg.dao.mapper;

import com.zjg.dao.model.PickUpCallSettingDO;
import com.zjg.dao.model.PickUpCallSettingDOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PickUpCallSettingDAO {
    long countByExample(PickUpCallSettingDOExample example);

    int deleteByExample(PickUpCallSettingDOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PickUpCallSettingDO record);

    int insertSelective(PickUpCallSettingDO record);

    List<PickUpCallSettingDO> selectByExample(PickUpCallSettingDOExample example);

    PickUpCallSettingDO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PickUpCallSettingDO record, @Param("example") PickUpCallSettingDOExample example);

    int updateByExample(@Param("record") PickUpCallSettingDO record, @Param("example") PickUpCallSettingDOExample example);

    int updateByPrimaryKeySelective(PickUpCallSettingDO record);

    int updateByPrimaryKey(PickUpCallSettingDO record);
}