package com.gao.customizeClass;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午10:17
 */
public class MyThreadFactoryMain {
    public static void main(String[] args) throws InterruptedException {
        MyThreadFactory threadFactory = new MyThreadFactory("wangchen");

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = threadFactory.newThread(myRunnable);

        thread.start();
        thread.join();

        System.out.println(thread);
    }
}
