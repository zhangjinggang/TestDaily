package com.zjg.test.compare.temp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class TestList {
    public static void main(String[] args) {

        String str = "1,2,3,4,5,5,5,5";
        String[] vcodeArr = str.split(",");
        List<String> vcodeList = Arrays.asList(vcodeArr);
        System.out.println(vcodeList.size());
        List<String> listWithoutDup = new ArrayList<String>(new LinkedHashSet<String>(vcodeList));
        String[] strings = new String[listWithoutDup.size()];
        listWithoutDup.toArray(strings);
        for(String s: strings) {
            System.out.println(s);
        }
    }
    String aa(){
        return "ss";
    }
}
