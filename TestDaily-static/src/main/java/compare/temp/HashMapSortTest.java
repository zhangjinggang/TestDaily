package compare.temp;

import java.io.*;
import java.util.HashMap;

public class HashMapSortTest {
    public static void main(String[] args) throws IOException {
        HashMap<String,String> map = new HashMap<>();

        for(int i=0; i<16; i++){
            map.put(i+"",i+1+"");
        }
        for(String key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }
    }
}
