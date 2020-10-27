package compare.temp;

import java.lang.reflect.Field;

public class FiledTest
{
    public static void main(String[] args) throws Exception
    {
        Field field= A.class.getDeclaredField("fild");
        int a= (Integer)field.get(new A()) ;
//        int c= (Integer)field.get(null) ; //不是静态字段不能传null
        System.out.println(a);

        Field staticfield= A.class.getDeclaredField("staticFild");
        int b= (Integer)staticfield.get("") ;
        int d= (Integer)staticfield.get(null) ;
        System.out.println(b);
        System.out.println(d);

        A.class.getMethod("aa");
    }

}

class A {
    int fild = 3;
    static int staticFild = 4;

 public   void aa() {
        int a = 0;
    }
}

