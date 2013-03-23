package com.gao.first;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 上午9:21
 */
public class SearchFileMainTest {
    public static void main(String[] args) {
        SearchFile searchFile = new SearchFile("G:/", "JAVA并发编程实践.pdf");
        Thread thread = new Thread(searchFile);
        thread.start();

        try {
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
