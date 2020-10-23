package com.zjg.test.compare.sql;

import java.io.*;

// 将compareResult文件中重命名（先删除再创建）索引的语句删除
public class HandlerSqlNologging {
    public static void main(String[] args) throws IOException {
        File orgFile = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\fix.sql");
        File sqlFileDel = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\delindex.sql");
        File sqlFileFix = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\fixindex.sql");
        BufferedReader bufferedReaderOrg = new BufferedReader(new FileReader(orgFile));
        BufferedWriter bufferedWriterDel = new BufferedWriter(new FileWriter(sqlFileDel));
        BufferedWriter bufferedWriterFix = new BufferedWriter(new FileWriter(sqlFileFix));
        String strOne = "";
        String strTwo = "";
        String strThree = "";
        String strNormal = "";
        while ((strNormal = bufferedReaderOrg.readLine()) != null) {
            if (strNormal.trim().startsWith("drop index ")) {
                strOne = strNormal;
                strNormal = bufferedReaderOrg.readLine();
                if (strNormal.trim().startsWith("create index ")) {
                    strTwo = strNormal;
                    strNormal = bufferedReaderOrg.readLine();
                    if(strNormal.trim().equals("nologging  local;")){
                        strThree = strNormal;
                        bufferedWriterDel.write(strOne);
                        bufferedWriterDel.newLine();
                        bufferedWriterDel.write(strTwo);
                        bufferedWriterDel.newLine();
                        bufferedWriterDel.write(strThree);
                        bufferedWriterDel.newLine();
                    }else{
                        bufferedWriterFix.write(strOne);
                        bufferedWriterFix.newLine();
                        bufferedWriterFix.write(strTwo);
                        bufferedWriterFix.newLine();
                        bufferedWriterFix.write(strNormal);
                        bufferedWriterFix.newLine();
                    }
                }else{
                    bufferedWriterFix.write(strOne);
                    bufferedWriterFix.newLine();
                    bufferedWriterFix.write(strNormal);
                    bufferedWriterFix.newLine();
                }
            }else{
                bufferedWriterFix.write(strNormal);
                bufferedWriterFix.newLine();
            }
        }
        bufferedReaderOrg.close();
        bufferedWriterDel.flush();
        bufferedWriterDel.close();
        bufferedWriterFix.flush();
        bufferedWriterFix.close();
    }
}
