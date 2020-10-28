package compare.temp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.zjg.dao.model.*;

import java.util.*;

/**
 * @author zjg
 * @description: 拷贝一个Set集合和Map集合
 * @date 2020/10/27 15:50
 */
public class CopySet {

    public static void main(String[] args) {

//        copySet();
        copyMap();
    }

    private static void copySet() {
        Set<BusinessDO> businessDOSet = new HashSet<>();
        BusinessDO businessDO = new BusinessDO();
        businessDO.setEndTime(123L);
        businessDO.setGmtCreate(new Date());
        businessDOSet.add(businessDO);

        String str = JSON.toJSONString(businessDOSet);
        List<BusinessDO> businessDOS = JSON.parseArray(str, BusinessDO.class);
        Set<BusinessDO> set = new HashSet<>();
        set.addAll(businessDOS);
        System.out.println(set);
    }

    private static void copyMap() {
        Map<BusinessDO,List<DeviceDO>> businessDOMap = new HashMap<>();
        BusinessDO businessDO = new BusinessDO();
        businessDO.setEndTime(123L);
        businessDO.setGmtCreate(new Date());

        List<DeviceDO> deviceDOList = new ArrayList<>();
        DeviceDO deviceDO = new DeviceDO();
        deviceDO.setAuthCode("test");
        deviceDO.setGmtCreate(new Date());
        deviceDOList.add(deviceDO);
        businessDOMap.put(businessDO,deviceDOList);

        String str = JSON.toJSONString(businessDOMap);
        Map<BusinessDO,List<DeviceDO>> map = (Map<BusinessDO, List<DeviceDO>>) JSON.parseObject(str,new TypeReference<HashMap<BusinessDO,List<DeviceDO>>>(){});
        System.out.println(map);
    }
}
