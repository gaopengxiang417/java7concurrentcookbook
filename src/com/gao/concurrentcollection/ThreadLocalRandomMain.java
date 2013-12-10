package com.gao.concurrentcollection;

/**
 * User: wangchen.gpx
 * Date: 13-12-10
 * Time: 下午10:49
 */
public class ThreadLocalRandomMain {
    public static void main(String[] args) {
        Thread[] threads = new Thread[3];

        for (int i = 0; i < 3; i++) {
            threads[i] = new Thread(new ThreadLocalRandomTask());
            threads[i].start();
        }

        System.out.println("main done.......");
    }
}
