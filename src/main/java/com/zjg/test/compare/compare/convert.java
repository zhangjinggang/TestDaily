package com.zjg.test.compare.compare;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author zjg
 * @description: TODO
 * @date 2019/12/617:05
 */
public class convert {

    public static void main(String[] args) throws Exception {

        ZonedDateTime zonedDateTime = LocalDate.now().atStartOfDay(ZoneId.systemDefault());
        Date date = Date.from(zonedDateTime.toInstant());
        Integer a = 1;
        Integer b = 1;
        try{
            Integer c = new Integer("s");
            isZeroOrOne(c,"s");
        }catch (Exception e){
            System.out.println("test");
        }
        System.out.println("final");

    }
    public static void isZeroOrOne(int flag, String message)
            throws Exception{
        if (flag != 0 || flag != 1) {
            throw new Exception(message);
        }
    }
}
