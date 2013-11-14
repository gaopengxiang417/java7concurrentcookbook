package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:18
 */
public class MyJob implements Runnable {
    private PrintQueue printQueue;

    public MyJob(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.printf("%s,start to print job\n" , Thread.currentThread().getName());

        printQueue.printJob(null);

        System.out.printf("%s,end to print job\n" , Thread.currentThread().getName());
    }
}
