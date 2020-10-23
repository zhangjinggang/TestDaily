package com.zjg.test.compare.compare;

/**
 * @author zjg
 * @description:
 * @date 2020/1/2 10:20
 */
public class TestThreadLocal {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };
    public static void main(String[] args) throws Exception {
        plus();
    }
    private static void plus() throws Exception {
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    Integer  a = threadLocal.get();
                    a++;
                    threadLocal.set(a);
                    System.out.println("plus:" + Thread.currentThread().getName() + ": " + threadLocal.get());

                }
            }.start();
        }
    }

}
