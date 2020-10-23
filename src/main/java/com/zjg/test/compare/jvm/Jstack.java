package com.zjg.test.compare.jvm;

public class Jstack {

    public static void main(String[] args) {
        doDeadCircle();
    }
    public static void doDeadCircle(){
        new Thread(()->{
            int i = 1;
            while(i > 0){
                System.out.println("死循环中。。。");
            }
        }) .start();
    }
}
