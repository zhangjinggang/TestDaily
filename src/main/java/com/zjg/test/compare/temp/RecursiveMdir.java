package com.zjg.test.compare.temp;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class RecursiveMdir {
    public static void main(String[] args) {

        String directories = "H:\\BOHProject\\src\\main\\webapp\\view\\boh\\programManage";
        File file = new File(directories);
        boolean result = file.mkdirs();
        System.out.println("Status = " + result);
    }
}
