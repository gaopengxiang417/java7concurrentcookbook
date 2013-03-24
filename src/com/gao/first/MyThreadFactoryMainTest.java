package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午1:19
 */
public class MyThreadFactoryMainTest {
    public static void main(String[] args) {
        MyTask myTask = new MyTask();

        MyThreadFactory myfactory = new MyThreadFactory("myfactory");

        for (int i = 0; i < 4; i++) {
            Thread thread = myfactory.newThread(myTask);
            thread.start();
        }

        System.out.println("status.......");
        System.out.println(myfactory.getStatus());
    }
}
