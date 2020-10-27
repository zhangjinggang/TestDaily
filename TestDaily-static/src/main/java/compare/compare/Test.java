package compare.compare;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class Test {
//    static {
//        try {
//            InputStream in = Test.class.getClass().getResource("/NTV.dll").openStream();
//            File dll = File.createTempFile("NTV", ".dll");
//            FileOutputStream out = new FileOutputStream(dll);
//
//            int i;
//            byte[] buf = new byte[1024];
//            while ((i = in.read(buf)) != -1) {
//                out.write(buf, 0, i);
//            }
//
//            in.close();
//            out.close();
//            dll.deleteOnExit();
//
//            System.load(dll.toString());//
//        } catch (Exception e) {
//            System.err.println("load jni error!");
//        }
//    }


    public native int func(String str);


    public static void main(String[] args) {
//        Random rand = new Random();
//        StringBuffer sb=new StringBuffer();
//        for (int i=0;i<32;i++){
//            int randNum = rand.nextInt(10);
//            sb=sb.append(randNum);
//        }
//        System.out.println(sb.toString());

        System.out.println((double)(86399999/1000)/3600);

        List<String> stringList = new ArrayList<>();
        stringList.add("12");
        stringList.add("12");
        stringList.add("12");
        System.out.println(stringList);


    }

}