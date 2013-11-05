package com.gao.threaSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:29
 */
public class PrintQueue {

    private Lock lock = new ReentrantLock(true);

    public void printJob() {
        try{
            lock.lock();

            long duration = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() +
            "is print job " + duration / 1000 + "s");

            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
