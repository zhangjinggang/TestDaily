package com.zjg.test.compare.sql;

import java.io.*;

public class HandlerSqlCompareFindPartitionTableNameAndSpace {
    //输出原表结构sql文件中每个table后partition的最大日期的表名和tablespace
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\changfeng.sql");
        File sqlFilePartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\partitionTableNameTableSpace.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFilePartion));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        String tableName = "";
        String time = "";
        String tableSpace = "";
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
                        tableSpace = bufferedReader.readLine();
                        tableSpace = tableSpace.trim();
                        tableSpace = tableSpace.trim().substring(11,tableSpace.length());
                    }
                    if(strDel.trim().equals(");")){
                        if(!time.endsWith("values less than ('2030-12-01')")){
                            bufferedWriterPartion.write(tableName+"    "+tableSpace);
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
