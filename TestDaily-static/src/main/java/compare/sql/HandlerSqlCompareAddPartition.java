package compare.sql;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HandlerSqlCompareAddPartition {
    //正常拼接add partition,拼接的格式同plsql脚本写法
    public static void main(String[] args) throws IOException {
        File sqlFileTableName = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\tableName.sql");
        File sqlFileOrgPartition = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\del.sql");
        File sqlFileAddPartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\addPartition.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFileAddPartion));
        BufferedReader bufferedReaderTableName = new BufferedReader(new FileReader(sqlFileTableName));
        BufferedReader bufferedReaderPartition = new BufferedReader(new FileReader(sqlFileOrgPartition));
        //读取table
        List<String> tableNameList = new ArrayList<>();
        String strTableName = "";
        while((strTableName = bufferedReaderTableName.readLine()) != null){
            tableNameList.add(strTableName.trim());
        }

        boolean flag = true;
        String strLine = "";
        String strAdd = "";
        String tableName = "";
        while((strLine = bufferedReaderPartition.readLine()) != null){
            if(strLine.trim().startsWith("alter table ")){
                tableName = strLine;
                tableName = tableName.trim();
                tableName = tableName.substring(12,tableName.length());
                if(tableNameList.contains(tableName)){
                    bufferedWriterPartion.write(strLine);
                    bufferedWriterPartion.newLine();
                    flag = true;
                    while(flag && (strAdd = bufferedReaderPartition.readLine()) != null ){
                        if(strAdd.trim().startsWith("add partition P_2021")||
                                strAdd.trim().startsWith("add partition P_2022")||
                                strAdd.trim().startsWith("add partition P_2023")||
                                strAdd.trim().startsWith("add partition P_2024")||
                                strAdd.trim().startsWith("add partition P_2025")||
                                strAdd.trim().startsWith("add partition P_2026")||
                                strAdd.trim().startsWith("add partition P_2027")||
                                strAdd.trim().startsWith("add partition P_2028")||
                                strAdd.trim().startsWith("add partition P_2029")||
                                strAdd.trim().startsWith("add partition P_2030")){
                            if(strAdd.trim().equals("add partition P_20301201 values less than ('2030-12-01')")){
                                //循环完这一个表后不再循环
                                flag = false;
                            }
                            bufferedWriterPartion.write(strAdd);
                            bufferedWriterPartion.newLine();
                            while((strAdd = bufferedReaderPartition.readLine()) != null){
                                bufferedWriterPartion.write(strAdd);
                                bufferedWriterPartion.newLine();
                                if(strAdd.trim().equals(");")){
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();

    }
}
