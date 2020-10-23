package com.zjg.test.compare.sql;

import java.io.*;

public class CompareSqlDropAddPartirion {
    //删除差异sql中add partition的语句
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\compare.sql");
        File sqlFileDel = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\del.sql");
        File sqlFileDes = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\fix.sql");
        BufferedWriter bufferedWriterDel =  new BufferedWriter(new FileWriter(sqlFileDel));
        BufferedWriter bufferedWriterDes =  new BufferedWriter(new FileWriter(sqlFileDes));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        String strDel = "";
        StringBuilder strBuilderFixResult = new StringBuilder();
        StringBuilder strBuilderDel = new StringBuilder();
        boolean flagBreak = false;
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().equals("-- Add new partitions")){
                bufferedWriterDel.write(strFix);
                bufferedWriterDel.newLine();
                flagBreak = false;
                while((strDel = bufferedReader.readLine()) != null && !flagBreak){
                    if(strDel.trim().equals("add partition P_20301201 values less than ('2030-12-01')")){
                        bufferedWriterDel.write(strDel);
                        bufferedWriterDel.newLine();
                        while((strDel = bufferedReader.readLine()) != null){
                            if(strDel.trim().equals(");")){
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
