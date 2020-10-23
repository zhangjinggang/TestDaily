package com.zjg.test.compare.sql;

import java.io.*;

public class HandlerSqlCompareFindPartitionTableName {
    //输出
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\changfeng.sql");
        File sqlFilePartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\tableName.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFilePartion));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        String tableName = "";
        String time = "";
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().startsWith("prompt Creating table")){
                tableName = strFix;
                tableName = tableName.trim();
                tableName = tableName.substring(22,tableName.length());
            }
            if(strFix.trim().startsWith("partition by range ")){
                while((strDel = bufferedReader.readLine()) != null){
                    if(strDel.startsWith("  partition ")){
                        time = strDel;
                    }
                    if(strDel.trim().equals(");")){
                        if(!time.endsWith("values less than ('2030-12-01')")){
                            bufferedWriterPartion.write(tableName);
                            bufferedWriterPartion.newLine();
                        }
                        break;
                    }
                }
            }
        }

        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();

    }
}
