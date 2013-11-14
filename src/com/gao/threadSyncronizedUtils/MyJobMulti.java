package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:47
 */
public class MyJobMulti implements Runnable {
    private PrintQueueMutl printQueueMutl;

    public MyJobMulti(PrintQueueMutl printQueueMutl) {
        this.printQueueMutl = printQueueMutl;
    }

    @Override
    public void run() {
        System.out.printf("%s,start to print \n" , Thread.currentThread().getName());

        printQueueMutl.printJob(null);

        System.out.printf("%s,end to print \n" , Thread.currentThread().getName());
    }
}
