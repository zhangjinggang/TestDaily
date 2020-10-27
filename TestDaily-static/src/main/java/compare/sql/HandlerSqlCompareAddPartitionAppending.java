package compare.sql;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HandlerSqlCompareAddPartitionAppending {
    //拼接add partition，拼接的格式为每添加一个分区都有alter table语句
    public static void main(String[] args) throws IOException {
        File sqlFileTableName = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\tableName.sql");
        File tableSpace = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\tableSpace.sql");
        File sqlFileTempPartition = new File("G:\\BOH\\updateGrade\\guangzhoucheng\\testPartition\\tempPartition.sql");
        File sqlFileAddPartion = new File("G:\\BOH\\updateGrade\\changfengquanshui\\compare\\addPartition2.sql");
        BufferedWriter bufferedWriterPartion =  new BufferedWriter(new FileWriter(sqlFileAddPartion));
        BufferedReader bufferedReaderTableName = new BufferedReader(new FileReader(sqlFileTableName));
        BufferedReader bufferedReaderTempPartition = new BufferedReader(new FileReader(sqlFileTempPartition));
        BufferedReader bufferedReaderTableSpace = new BufferedReader(new FileReader(tableSpace));
        //读取tableName
        List<String> tableNameList = new ArrayList<>();
        String strTableName = "";
        while((strTableName = bufferedReaderTableName.readLine()) != null){
            tableNameList.add(strTableName.trim());
        }
        System.out.println(tableNameList.size());
        //读取tableSpace
        List<String> tableSpaceList = new ArrayList<>();
        String strTableSpace = "";
        while((strTableSpace = bufferedReaderTableSpace.readLine()) != null){
            tableSpaceList.add(strTableSpace.trim());
        }
        System.out.println(tableSpaceList.size());
        //读取tempPartition
        List<String> tempPartitionList = new ArrayList<>();
        String strTempPartition = "";
        while((strTempPartition = bufferedReaderTempPartition.readLine()) != null){
            tempPartitionList.add(strTempPartition);
        }
        System.out.println(tempPartitionList.size());
        String strLine = "";
        String strRead = "";
        for(int i=0;i<tableNameList.size();i++){
            for(int j=0;j<tempPartitionList.size();j++){
                strLine = "alter table " +  tableNameList.get(i);
                bufferedWriterPartion.write(strLine);
                bufferedWriterPartion.newLine();
                strRead = tempPartitionList.get(j);
                bufferedWriterPartion.write(strRead);
                bufferedWriterPartion.newLine();
                strRead = "    tablespace "+tableSpaceList.get(i)+"\n" +
                        "    pctfree 10\n" +
                        "    initrans 1\n" +
                        "    maxtrans 255\n" +
                        "    storage\n" +
                        "    (\n" +
                        "      initial 64K\n" +
                        "      next 1M\n" +
                        "      minextents 1\n" +
                        "      maxextents unlimited\n" +
                        "    );";
                bufferedWriterPartion.write(strRead);
                bufferedWriterPartion.newLine();
            }
        }
        bufferedWriterPartion.flush();
        bufferedWriterPartion.close();

    }
}
