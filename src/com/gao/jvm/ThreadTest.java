package com.gao.jvm;

import java.util.ArrayList;

/**
 * User: wangchen.gpx
 * Date: 13-10-25
 * Time: 下午4:52
 */
public class ThreadTest {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {


        list.add("1");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("in thread..");
                list = null;
            }
        }).start();

        Thread.sleep(1000);
        for (String s : list) {
            Thread.sleep(10000);
            System.out.println(s);
        }
    }
}
