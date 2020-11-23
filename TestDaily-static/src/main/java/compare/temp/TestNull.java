package compare.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestNull {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        Map<String,List<String>> map = new HashMap<>();
        map.put("ss",list);
        list.add("b");
        System.out.println(map.get("ss").toString());
    }

}
