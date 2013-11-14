package com.gao.threadSyncronizedUtils;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:36
 */
public class PrintQueueMutl {
    private Semaphore semaphore;

    private boolean[] activeArray;

    private Lock  lock;

    public PrintQueueMutl() {
        semaphore = new Semaphore(3);
        activeArray = new boolean[3];
        for (int i = 0; i < activeArray.length; i++) {
            activeArray[i] = true;
        }
        lock = new ReentrantLock();
    }

    public void printJob(Object object) {
        try {
            semaphore.acquire();

            int printer = getPrinter();

            int duration = (int) (Math.random()*1000);

            System.out.printf("%s,printing a job ,duration:%d, printer=%d\n" ,
                    Thread.currentThread().getName() , duration , printer);

            Thread.sleep(duration);

            activeArray[printer] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }

    private int getPrinter() {
        int re = -1;
        try {
            lock.lock();
            for (int i = 0 ; i< activeArray.length ; i++) {
                if (activeArray[i]) {
                    re = i;
                    activeArray[i] = false;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return re;
    }
}
