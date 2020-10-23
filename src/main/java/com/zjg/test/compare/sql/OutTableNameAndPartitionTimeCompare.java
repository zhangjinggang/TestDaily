package com.zjg.test.compare.sql;

import java.io.*;

//  输出compareResult文件中每个table后add partition的最大日期
public class OutTableNameAndPartitionTimeCompare {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\compare.sql");
        File sqlFilePartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\TableNameAndTimeCompare.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFilePartion));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String tableName = "";
        String tableNamePre = "";
        String time = "";
        boolean flag = false;
        while((strFix = bufferedReader.readLine()) != null) {
            if (strFix.trim().startsWith("alter table ")) {
                tableName = strFix.trim();
                tableName = tableName.substring(12, tableName.length());
                if (!tableNamePre.equals(tableName)&&flag) {
                    bufferedWriterPartion.write(tableNamePre + "   " + time);
                    bufferedWriterPartion.newLine();
                    flag = false;
                    continue;
                }
                strFix = bufferedReader.readLine();
                if (strFix.trim().startsWith("add partition ")) {
                    time = strFix.trim();
                    try{
                        time = time.substring(time.length() - 31, time.length());
                    }catch(StringIndexOutOfBoundsException e){
                        System.out.println(time);
                    }

                    tableNamePre = tableName;
                    flag = true;
                }
            }
        }
        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();

    }
}
