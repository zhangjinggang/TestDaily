package compare.compare;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author zjg
 * @description: 下发优化，对比优化前后生成的文件是否相同
 * @date 2020/10/16 15:56
 */
public class CompareFileUtils {

    final static String ORG_FILE_PATH = "C:\\Users\\Thinkpad\\Desktop\\1029\\下发优化\\5df99ccc28c571000109467c_SG001_201020013";
    final static String NEW_FILE_PATH = "C:\\Users\\Thinkpad\\Desktop\\1029\\下发优化\\5df99ccc28c571000109467c_SG001_201020014";
    final static String FILTER_NOT_COMPARE_FILE = "SettlementOperate.xml,choice.xml,store.xml,CODEDESC.xml";

    public static void main(String[] args) throws Exception {
        compareFile(ORG_FILE_PATH,NEW_FILE_PATH);
    }

    private static void compareFile(String orgFilePath, String newFilePath) throws Exception {
        //判断文件是否存在
        File orgFile = new File(orgFilePath);
        File newFile = new File(newFilePath);
        if(!orgFile.exists() || !newFile.exists()){
            throw new Exception("文件不存在");
        }

        //对比文件大小
//        if(orgFile.length() != newFile.length()){
//            throw new Exception("文件大小不相等");
//        }
        //对比子文件名
        compareSubFileName(orgFile, newFile);

        //对比文件内容
        compareSubFileContent(orgFile, newFile);

    }

    private static void compareSubFileContent(File orgFile, File newFile) throws IOException {
        List<File> orgFiles = Arrays.asList(orgFile.listFiles());
        List<File> newFiles = Arrays.asList(newFile.listFiles());
        Map<String, File> newFileMap = newFiles.stream().collect(Collectors.toMap(File::getName,v -> v));
        List<String> fileNameList = Arrays.asList( FILTER_NOT_COMPARE_FILE.split(","));
        for(File orgfile : orgFiles){
            if(fileNameList.contains(orgfile.getName())){
                continue;
            }
            if(orgfile.isDirectory()){
                compareSubFileContent(orgfile,newFileMap.get(orgfile.getName()));
                continue;
            }
            BufferedReader orgBufferedReader = new BufferedReader(new FileReader(orgfile));
            BufferedReader newBufferedReader = new BufferedReader(new FileReader(newFileMap.get(orgfile.getName())));
            String line = "";
            while((line = orgBufferedReader.readLine()) != null){
                if(!line.equals(newBufferedReader.readLine())){
                    System.out.println(orgfile.getName() + " 文件内容有不相同情况：");
                    break;
                }
            }
        }
    }

    private static void compareSubFileName(File orgFile, File newFile) throws Exception {
        List<File> orgFiles = Arrays.asList(orgFile.listFiles());
        List<File> newFiles = Arrays.asList(newFile.listFiles());
        List<String> newFileNames = newFiles.stream().map(File::getName).collect(Collectors.toList());
        Map<String, File> newFileMap = newFiles.stream().collect(Collectors.toMap(File::getName,v -> v));
        List<String> fileNameList = Arrays.asList( FILTER_NOT_COMPARE_FILE.split(","));
        if(orgFiles.size() != newFiles.size()){
            throw new Exception("文件数量不相等");
        }
        for(File file : orgFiles){
            if(fileNameList.contains(file.getName())){
                continue;
            };
            if(!newFileNames.contains(file.getName())){
                System.out.println(file.getName() + " 文件不都存在");
                throw new Exception("文件有不存在的情况");
            }
            if(file.length() != newFileMap.get(file.getName()).length()){
                System.out.println(file.getName() + " 文件大小不相等");
                throw new Exception("子文件大小有不相等的情况");
            }
            if(file.isDirectory()){
                compareSubFileName(file,newFileMap.get(file.getName()));
            }
        }
    }


}
