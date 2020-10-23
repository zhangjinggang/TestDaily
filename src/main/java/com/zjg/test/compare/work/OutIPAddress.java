package com.zjg.test.compare.work;

import java.io.*;

public class OutIPAddress {

    //程序入口
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("ip.txt");
        File sqlFileWrite = new File("ipChange.txt");
        //加快读速度 操作数组
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        //加快写速度
        BufferedWriter bufferedWriterPartion = new BufferedWriter(new FileWriter(sqlFileWrite));

        StringBuilder stringBuilder = new StringBuilder("");
        String strFix = "";
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix != null && !"".equals(strFix)){
                String[] ipStr = strFix.split("");
                bufferedWriterPartion.write("源IP:" + ipStr[0] + "目的IP" + ipStr[1] + ":时间戳:"+ipStr[ipStr.length-1]);
                System.out.println("源IP:"+ipStr[0]+"目的IP"+ipStr[1]+":时间戳:"+ipStr[ipStr.length-1]);
            }
        }

        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();

    }
}
