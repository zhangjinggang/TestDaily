package com.zjg.test.compare.compare;

import java.math.BigDecimal;

/**
 * @author zjg
 * @description: TODO
 * @date 2019/11/1410:58
 */
public class news {
    public static void main(String[] args) {
        double a = (1688.0*((29.0*1.0)/2999.00))/1.0;
        double d = (29.0*1.0)/2999.00;
        BigDecimal f = BigDecimal.valueOf(29.0).multiply(BigDecimal.valueOf(1.0)).divide(BigDecimal.valueOf(2999.00)).setScale(2,BigDecimal.ROUND_DOWN);
        BigDecimal b = BigDecimal.valueOf(1688.0).multiply(BigDecimal.valueOf(29.0).multiply(BigDecimal.valueOf(1.0)).divide(BigDecimal.valueOf(2999.00),30,BigDecimal.ROUND_DOWN)).divide(BigDecimal.valueOf(1.0));
        System.out.println(a);
        System.out.println(b);
        System.out.println(f);
        System.out.println("009669889963321107035678559519".length());
    }
}
