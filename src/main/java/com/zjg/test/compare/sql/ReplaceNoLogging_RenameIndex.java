package com.zjg.test.compare.sql;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

//重建索引（先删除再创建）的语句的调整替换  nologging  local;
public class ReplaceNoLogging_RenameIndex {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\fuhao\\fix.sql");
        File createSql = new File("G:\\BOH\\updateGrade\\fuhao\\fuhao.sql");
        File sqlFilePartion = new File("G:\\BOH\\updateGrade\\fuhao\\fix-ReplaceNOlogging.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFilePartion));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        BufferedReader bufferedCreateSql = new BufferedReader(new FileReader(createSql));
        String strFix = "";
        String strDel = "";
        String tableName = "";
        String time = "";
        String strCreateSqlOut = "";
        String strCreateSqlIn = "";
        //读取创建map
        Map<String,String> map = new HashMap<>();
        while((strCreateSqlOut = bufferedCreateSql.readLine()) != null){
            if(strCreateSqlOut.trim().startsWith("prompt Creating table ")) {
                tableName = strCreateSqlOut.trim();
                tableName = tableName.substring(22,tableName.length());
                while((strCreateSqlIn = bufferedCreateSql.readLine()) != null){
                    if(strCreateSqlIn.trim().startsWith("tablespace ")){
                        strCreateSqlIn = strCreateSqlIn.trim();
                        map.put(tableName,strCreateSqlIn.substring(11,strCreateSqlIn.length()));
                        break;
                    }
                }
            }
        }


        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().startsWith("drop index ")){
                bufferedWriterPartion.write(strFix);
                bufferedWriterPartion.newLine();
                strFix = bufferedReader.readLine();
                if(strFix.startsWith("create index ")){
                    bufferedWriterPartion.write(strFix);
                    bufferedWriterPartion.newLine();
                    tableName = strFix.substring(strFix.indexOf(" on ")+4,strFix.indexOf(" ("));
                    strFix = bufferedReader.readLine();
                    if(strFix.startsWith("  nologging  local;")){
                        bufferedWriterPartion.write("  tablespace "+(map.get(tableName).equals("USERS")?"USERS":"CHOICEALL"));
                        System.out.println(tableName+"   "+map.get(tableName));
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
                    }else{
                        bufferedWriterPartion.write(strFix);
                        bufferedWriterPartion.newLine();
                    }
                }else {
                    bufferedWriterPartion.write(strFix);
                    bufferedWriterPartion.newLine();
                }
            }else {
                bufferedWriterPartion.write(strFix);
                bufferedWriterPartion.newLine();
            }
        }
        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();
    }
}
