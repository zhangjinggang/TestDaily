package compare.sql;

import java.io.*;

public class HandlerSqlCompare3 {
    public static void main(String[] args) throws IOException {
        File sqlFileOrg = new File("G:\\BOH\\updateGrade\\fuhao\\fix-ReplaceNOlogging.sql");
        File sqlFileDes = new File("G:\\BOH\\updateGrade\\fuhao\\NologgingFix.sql");
        BufferedWriter bufferedWriterDel =  new BufferedWriter(new FileWriter(sqlFileDes));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(sqlFileOrg));
        String strFix = "";
        while((strFix = bufferedReader.readLine()) != null){
            if(strFix.trim().equals("nologging  local;")){
                bufferedWriterDel.write("  tablespace CHOICEALL");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  pctfree 10");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  initrans 2");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  maxtrans 255");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  storage");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  (");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("    initial 64K");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("    next 1M");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("    minextents 1");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("    maxextents unlimited");
                bufferedWriterDel.newLine();
                bufferedWriterDel.write("  );");
                bufferedWriterDel.newLine();
            }else{
                bufferedWriterDel.write(strFix);
                bufferedWriterDel.newLine();
            }

        }

        bufferedWriterDel.flush();
        bufferedWriterDel.close();
        bufferedReader.close();

    }
}
