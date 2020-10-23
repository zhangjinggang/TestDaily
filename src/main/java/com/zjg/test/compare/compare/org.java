package com.zjg.test.compare.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zjg
 * @description: TODO
 * @date 2019/11/1410:58
 */
public class org {

    public static void main(String[] args) throws Exception {
        List<OnlinePayConfig> onlinepayConfigList = new ArrayList<>();
        OnlinePayConfig onlinePayConfig1 = new OnlinePayConfig();
        onlinePayConfig1.setTenantId("1");
        onlinePayConfig1.setStoreId("2");
        onlinePayConfig1.setPayCode("3");
        OnlinePayConfig onlinePayConfig2 = new OnlinePayConfig();
        onlinePayConfig2.setTenantId("1");
        onlinePayConfig2.setStoreId("2");
        onlinePayConfig2.setPayCode("6");
        OnlinePayConfig onlinePayConfig3 = new OnlinePayConfig();
        onlinePayConfig3.setTenantId("7");
        onlinePayConfig3.setStoreId("3");
        onlinePayConfig3.setPayCode("9");
        OnlinePayConfig onlinePayConfig4 = new OnlinePayConfig();
        onlinePayConfig4.setTenantId("1");
        onlinePayConfig4.setStoreId("2");
        onlinePayConfig4.setPayCode("12");
        OnlinePayConfig onlinePayConfig5 = new OnlinePayConfig();
        onlinePayConfig5.setTenantId("13");
        onlinePayConfig5.setStoreId("14");
        onlinePayConfig5.setPayCode("3");
        OnlinePayConfig onlinePayConfig6 = new OnlinePayConfig();
        onlinePayConfig6.setTenantId("16");
        onlinePayConfig6.setStoreId("17");
        onlinePayConfig6.setPayCode("18");
        onlinepayConfigList.add(onlinePayConfig1);
        onlinepayConfigList.add(onlinePayConfig2);
        onlinepayConfigList.add(onlinePayConfig3);
        onlinepayConfigList.add(onlinePayConfig4);
        onlinepayConfigList.add(onlinePayConfig5);
        onlinepayConfigList.add(onlinePayConfig6);

        List<OnlinePayConfig> onlinePayConfigs = getOnlinepayConfig("1","2","3",onlinepayConfigList);
        System.out.println(onlinePayConfigs.toString());
    }

    private static List<OnlinePayConfig> getOnlinepayConfig(String vgroupcode, String vscode, String vtypcode, List<OnlinePayConfig> onlinepayConfigList) {
        return onlinepayConfigList.stream().filter(config -> config.getTenantId().equals(vgroupcode) &&
                config.getStoreId().equals(vscode)).collect(Collectors.toList());
    }
}
