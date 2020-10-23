package com.zjg.test.compare.sql;

import java.io.*;

public class HandlerSqlCompare4 {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\heji\\fix\\compareResultTest.sql");
        File sqlFileDel = new File("G:\\BOH\\heji\\fix\\del.sql");
        File sqlFileDes = new File("G:\\BOH\\heji\\fix\\fix.sql");
        BufferedWriter bufferedWriterDel =  new BufferedWriter(new FileWriter(sqlFileDel));
        BufferedWriter bufferedWriterDes =  new BufferedWriter(new FileWriter(sqlFileDes));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        boolean flagBreak = false;
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().equals("-- Add new partitions")){
                bufferedWriterDes.write(strFix);
                bufferedWriterDes.newLine();
                flagBreak = false;
                while((strDel = bufferedReader.readLine()) != null && !flagBreak){
                    if(strDel.trim().equals("add partition P_20151201 values less than ('2015-12-01')")){
                        bufferedWriterDel.write(strDel);
                        bufferedWriterDel.newLine();
                        while((strDel = bufferedReader.readLine()) != null){
                            if(strDel.trim().equals("maxtrans 255;")){
                                flagBreak = true;
                                break;
                            }
                            bufferedWriterDel.write(strDel);
                            bufferedWriterDel.newLine();
                        }
                    }
                    bufferedWriterDel.write(strDel);
                    bufferedWriterDel.newLine();
                }
                bufferedWriterDes.write(strDel);
                bufferedWriterDes.newLine();
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
