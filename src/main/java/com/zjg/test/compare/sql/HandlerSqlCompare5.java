package com.zjg.test.compare.sql;

import java.io.*;

public class HandlerSqlCompare5 {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\fuhao\\compareResultTest.sql");
        File sqlFileDel = new File("G:\\BOH\\updateGrade\\fuhao\\del.sql");
        File sqlFileDes = new File("G:\\BOH\\updateGrade\\fuhao\\fix.sql");
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
                strFix = bufferedReader.readLine();
                if(strFix.trim().startsWith("--")){
                    bufferedWriterDes.write(strFix);
                    bufferedWriterDes.newLine();
                    continue;
                }else{
                    bufferedWriterDel.write(strFix);
                    bufferedWriterDel.newLine();
                }
                flagBreak = false;
                while((strDel = bufferedReader.readLine()) != null && !flagBreak){
                    if(strDel.trim().equals("add partition P_20301201 values less than ('2030-12-01')")){
                        bufferedWriterDel.write(strDel);
                        bufferedWriterDel.newLine();
                        while((strDel = bufferedReader.readLine()) != null){
                            if(strDel.startsWith("    );")){
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
