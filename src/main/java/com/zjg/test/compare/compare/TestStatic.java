package com.zjg.test.compare.compare;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjg
 * @description: TODO
 * @date 2019/11/1410:58
 */
public class TestStatic {


    public static void main(String[] args) throws IOException {
        String str = "SELECT tkdc.koubeiId as koubeiid, tkdc.tenantId as tenantid,tkdc.pid,tkdc.id,tkdc.cateType as catetype\n" +
                "        from t_koubei_dish_cate tkdc\n" +
                "        where\n" +
                "        tkdc.tenantId = \"5bdbb67b834e900001bbf86c\"\n" +
                "        and (tkdc.cateType = 'cook' or tkdc.cateType = 'dish')\n" +
                "        and";
        String str2 = "(tkdc.id = \"b4097bd407974f48b6d1fe369e8d3af7\"\n" +
                "                and tkdc.pid = '2088121848295365') or ";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        for (int i=0; i<2000; i++){
            stringBuilder.append(str2);
        }
        File file = new File("C:\\Users\\Thinkpad\\Desktop\\b.txt");
        Writer out =new FileWriter(file);
        out.write(stringBuilder.toString());
        out.close();
//        List<String> list = new ArrayList();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.subList(0,3);
//        System.out.println(list.toString());
//        for (int i = 0; i< 4;i++){
//            System.out.println(BatchUtil.stepIndex(i,3320,4,0,1000));
//        }

    }
}
