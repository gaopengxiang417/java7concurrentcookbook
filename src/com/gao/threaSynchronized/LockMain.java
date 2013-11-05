package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:33
 */
public class LockMain {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new LockRunnable(printQueue));
        }

        for (Thread thread : threads) {
            thread.start();
        }


    }
}
