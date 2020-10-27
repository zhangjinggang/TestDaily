package compare.jvm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zjg
 * @description:
 * @date 2019/12/30 15:39
 */
public class TestCmd {
    static ProcessBuilder processBuilder;
    public static void main(String[] args) {
        try {
            List<String> params2 = new ArrayList<String>();
            params2.add("javac");
            params2.add("TestList.java");
            String str = "l";
            for(int i=0;i<100*1024;i++){
                params2.add(str);
            }
            processBuilder = new ProcessBuilder(params2);
            processBuilder.directory(new File("F:/"));
            Process process2 = processBuilder.start();
            System.out.println(process2.waitFor());
            System.out.println("进程对象:" + process2);
            BufferedReader br2 = new BufferedReader(new InputStreamReader(process2.getInputStream(), "GBK"));
            String line2;
            while ((line2 = br2.readLine()) != null) {
                System.out.println(line2);
            }
//
//            List<String> params = new ArrayList<String>();
//            params.add("javac");
//            params.add("TestLength.java");
//            processBuilder = new ProcessBuilder(params);
//            processBuilder.directory(new File("F:/"));
//            Process process = processBuilder.start();
//            System.out.println(process.waitFor());
//            System.out.println("进程对象:" + process);
//            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream(), "GBK"));
//            String line;
//            while ((line = br.readLine()) != null) {
//                System.out.println(line);
//            }


        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("编译出错");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
