package com.zjg.test.compare.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class TestListToString {
    public static void main(String[] args) {

        String str = "1,2,3,4,5,5,5,5";
        String[] vcodeArr = str.split(",");
        List<String> vcodeList = Arrays.asList(vcodeArr);
        System.out.println(vcodeList.toString().substring(1,vcodeList.toString().length()-1));
    }
}
