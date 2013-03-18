package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-18
 * Time: 下午6:32
 */
public class ThreadPropertiesTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadProperties threadProperties = new ThreadProperties();
        Thread thread = new Thread(threadProperties);
        thread.start();

        Thread.sleep(1000);

        System.out.println(thread.getId());
        System.out.println(Thread.currentThread().getId());
        System.out.println(thread.getName());
        System.out.println(Thread.currentThread().getName());

        System.out.println(thread.isDaemon());
        System.out.println(Thread.currentThread().isDaemon());

        System.out.println(thread.getPriority());
        System.out.println(Thread.currentThread().getPriority());

        System.out.println("this "+thread.getState());
        System.out.println("current: "+Thread.currentThread().getState());
    }
}
