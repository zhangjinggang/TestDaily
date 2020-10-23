package com.zjg.test.compare.sql;

import java.io.*;

public class HandlerSqlCompare2 {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\heji\\fixTest.sql");
        File sqlFileDel = new File("G:\\BOH\\heji\\indexDel.sql");
        File sqlFileDes = new File("G:\\BOH\\heji\\IndexFix.sql");
        BufferedWriter bufferedWriterDel =  new BufferedWriter(new FileWriter(sqlFileDel));
        BufferedWriter bufferedWriterDes =  new BufferedWriter(new FileWriter(sqlFileDes));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        String strDropIndex = "";
        StringBuilder strBuilderFixResult = new StringBuilder();
        StringBuilder strBuilderDel = new StringBuilder();
        boolean flagBreak = false;
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().equals("-- Create/Recreate indexes")||
                    strFix.startsWith("drop index ")||
                    strFix.startsWith("create index ")||
                    strFix.trim().equals("nologging  local;")){
                bufferedWriterDel.write(strFix);
                bufferedWriterDel.newLine();
            }else{
                bufferedWriterDes.write(strFix);
                bufferedWriterDes.newLine();
            }
        }

        bufferedWriterDes.flush();
        bufferedWriterDel.flush();

        bufferedWriterDes.close();
        bufferedWriterDel.close();
        bufferedReader.close();

    }
}
