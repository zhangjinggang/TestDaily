package compare.compare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class TestTryCatch {


    public static void main(String[] args) throws Exception {
//        try {
//            int a=1/0;
//        }catch (Exception e){
//            System.out.println("111111");
//        }
//        System.out.println("2222222222");
        String ip = "jdbc:mysql://localhost:3306/mis?useSSL=false&useUnicode=true&characterEncoding=utf8";
        int index = ip.indexOf("//")+2;
        int index2 = ip.indexOf(":",index);
        ip = ip.substring(index,index2);
        System.out.println(ip);

    }

}