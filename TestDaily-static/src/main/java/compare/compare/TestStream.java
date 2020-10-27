package compare.compare;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zjg
 * @description: TODO
 * @date 2019/11/1410:58
 */
public class TestStream {

    public static void main(String[] args) throws Exception {
        List<SellOff> sellOffList = new ArrayList<>();
        SellOff sellOff1 = new SellOff();
        sellOff1.setDishId("111");
        sellOff1.setStoreId("222");
        sellOff1.setTenantId("333");
        SellOff sellOff2 = new SellOff();
        sellOff2.setDishId("3452");
        sellOff2.setStoreId("1243");
        sellOff2.setTenantId("222");
        SellOff sellOff3 = new SellOff();
        sellOff3.setDishId("333");
        sellOff3.setStoreId("333");
        sellOff3.setTenantId("333");
        SellOff sellOf4f = new SellOff();
        sellOf4f.setDishId("444");
        sellOf4f.setStoreId("444");
        sellOf4f.setTenantId("444");
        SellOff sellOff5 = new SellOff();
        sellOff5.setDishId("555");
        sellOff5.setStoreId("555");
        sellOff5.setTenantId("555");
        sellOffList.add(sellOff1);
        sellOffList.add(sellOff2);
        sellOffList.add(sellOff3);
        sellOffList.add(sellOf4f);
        sellOffList.add(sellOff5);
//        List<String> stringList = sellOffList.stream().filter(sellOff ->sellOff.getTenantId().equals("555") &&
//                sellOff.getStoreId().equals("558") &&
//                sellOff.getDishId().equals("555")).map(sellOff -> sellOff.getDishId()).collect(Collectors.toList());
//        SellOff str = sellOffList.stream().filter(sellOff ->sellOff.getTenantId().equals("555") &&
//                sellOff.getStoreId().equals("558") &&
//                sellOff.getDishId().equals("555")).findFirst().orElseGet(()->null);
//        System.out.println(str);
        System.out.println(sellOffList.stream().filter(sellOff ->sellOff.getTenantId().equals("5455")).findFirst().orElse(get()).toString());

    }

    private static SellOff get() {
        SellOff sellOf4f = new SellOff();
        sellOf4f.setDishId("444");
        sellOf4f.setStoreId("444");
        sellOf4f.setTenantId("444");
        System.out.println("or执行");
        return sellOf4f;
    }

}
