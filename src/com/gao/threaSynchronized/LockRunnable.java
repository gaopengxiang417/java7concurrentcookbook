package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:33
 */
public class LockRunnable implements Runnable {
    private PrintQueue printQueue;

    public LockRunnable(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
            " is start print");
        printQueue.printJob();

        System.out.println(Thread.currentThread().getName() + "is end print");
    }
}
