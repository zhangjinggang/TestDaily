package com.zjg.test.compare.sql;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//新建表，新建索引的语句的调整替换  nologging  local;
public class ReplaceNoLogging_CreateTable {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\fixindex.sql");
        File sqlFilePartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\fix-ReplaceNOlogging.sql");
        BufferedWriter bufferedWriterPartion = new BufferedWriter(new FileWriter(sqlFilePartion));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        String tableName = "";
        String time = "";
        String strCreateSqlOut = "";
        String strCreateSqlIn = "";
        //读取创建map
        Map<String, String> map = new HashMap<>();
        while ((strCreateSqlOut = bufferedReader.readLine()) != null) {
            if (strCreateSqlOut.trim().startsWith("create table ")) {
                tableName = strCreateSqlOut.trim();
                tableName = tableName.substring(13);
                while ((strCreateSqlIn = bufferedReader.readLine()) != null) {
                    if (strCreateSqlIn.trim().startsWith("tablespace ")) {
                        strCreateSqlIn = strCreateSqlIn.trim();
                        map.put(tableName, strCreateSqlIn.substring(11));
                        break;
                    }
                }
            }
        }
        bufferedReader.close();
        bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        while ((strFix = bufferedReader.readLine()) != null) {
            if (strFix.startsWith("create index ")) {
                bufferedWriterPartion.write(strFix);
                bufferedWriterPartion.newLine();
                tableName = strFix.substring(strFix.indexOf(" on ") + 4, strFix.indexOf(" ("));
                strFix = bufferedReader.readLine();
                if (strFix.startsWith("  nologging  local;")) {
                    bufferedWriterPartion.write("  tablespace " + map.get(tableName));
                    System.out.println(tableName + "   " + map.get(tableName));
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  pctfree 10");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  initrans 2");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  maxtrans 255");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  storage");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  (");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("    initial 64K");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("    next 1M");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("    minextents 1");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("    maxextents unlimited");
                    bufferedWriterPartion.newLine();
                    bufferedWriterPartion.write("  );");
                    bufferedWriterPartion.newLine();
                } else {
                    bufferedWriterPartion.write(strFix);
                    bufferedWriterPartion.newLine();
                }
            } else {
                bufferedWriterPartion.write(strFix);
                bufferedWriterPartion.newLine();
            }

        }
        bufferedReader.close();
        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();
    }
}
