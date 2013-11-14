package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:21
 */
public class PrintQueueMain {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();

        for (int i = 0; i < 10; i++) {
            new Thread(new MyJob(printQueue)).start();
        }

        System.out.println("main...........");
    }
}
