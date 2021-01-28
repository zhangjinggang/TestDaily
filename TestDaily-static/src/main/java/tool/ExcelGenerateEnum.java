package tool;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * @author zjg
 * @description: excel文档操作  菜品导入文件头转成枚举文件
 * @date 2021/1/22 15:10
 */
public class ExcelGenerateEnum {


    public static void main(String[] args) {
//        Workbook workbook = getWorkbookByInputStream(inputStream, fileName);
        // 得到第一个工作表
//        Sheet sheet = workbook.getSheetAt(0);

    }

    public static Workbook getWorkbookByInputStream(InputStream iStream, String fileName) {
        Workbook workbook;
        try {
            // 先读到内存
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            IOUtils.copy(iStream, bout);
            iStream.close();
            bout.close();
            byte[] bytes = bout.toByteArray();
            //
            if (fileName.toLowerCase().endsWith(".xls")) {
                try{
                    iStream = new ByteArrayInputStream(bytes);
                    workbook = new HSSFWorkbook(iStream);
                }catch(Exception e){
                    //可能手动改了文件后缀名，再抢救一下
                    try{
                        IOUtils.closeQuietly(iStream);
                        iStream = new ByteArrayInputStream(bytes);
                        workbook = new XSSFWorkbook(iStream);
                    }catch(Exception ex){
                        System.out.println("创建Workbook异常。"+ex);
                        throw ex;
                    }
                }
            } else if (fileName.toLowerCase().endsWith(".xlsx")) {
                try{
                    iStream = new ByteArrayInputStream(bytes);
                    workbook = new XSSFWorkbook(iStream);
                }catch(Exception e){
                    //可能手动改了文件后缀名，再抢救一下
                    try{
                        IOUtils.closeQuietly(iStream);
                        iStream = new ByteArrayInputStream(bytes);
                        workbook = new HSSFWorkbook(iStream);
                    }catch(Exception ex){
                        System.out.println("创建Workbook异常。"+ex);
                        throw ex;
                    }
                }
            } else {
                throw new RuntimeException("不支持的Excel扩展名");
            }
        } catch (Exception e){
            throw new RuntimeException("读取Excel文件内容异常，请确认文件后缀名与文件内容是否一致");
        }finally {
            IOUtils.closeQuietly(iStream);
        }
        return workbook;
    }
}
