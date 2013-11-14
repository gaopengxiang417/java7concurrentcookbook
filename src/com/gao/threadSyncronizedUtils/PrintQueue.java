package com.gao.threadSyncronizedUtils;

import java.util.concurrent.Semaphore;

/**
 * User: wangchen.gpx
 * Date: 13-11-14
 * Time: 下午9:13
 */
public class PrintQueue {
    private Semaphore semaphore;

    public PrintQueue() {
        semaphore = new Semaphore(1);
    }

    public void printJob(Object object) {
        try {
            semaphore.acquire();

            int duration = (int) (Math.random()*1000);

            System.out.printf("%s,printing a job duration %d\n" ,
                    Thread.currentThread().getName() , duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
}
