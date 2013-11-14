package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:48
 */
public class PrintQueueMultiMain {
    public static void main(String[] args) {
        PrintQueueMutl printQueueMutl = new PrintQueueMutl();

        for (int i = 0; i < 10; i++) {
            new Thread(new MyJobMulti(printQueueMutl)).start();
        }

        System.out.println("main.....");
    }
}
