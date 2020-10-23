package com.zjg.test.compare.jvm;

public class Jconsole {

    public static void main(String[] args) {
        doDeadlock();
    }
    public static void doDeadlock(){
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(()->{
            synchronized(lock1) {
                try {Thread.sleep(1000);}catch(Exception e) {}
                synchronized(lock2) {
                    System.out.println("线程1结束");
                }
            }
        }) .start();
        new Thread(()->{
            synchronized(lock2) {
                try {Thread.sleep(1000);}catch(Exception e) {}
                synchronized(lock1) {
                    System.out.println("线程2结束");
                }
            }
        }) .start();
    }
}
