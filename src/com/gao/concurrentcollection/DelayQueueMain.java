package com.gao.concurrentcollection;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午11:06
 */
public class DelayQueueMain {

    public static final int MAX = 5;

    public static void main(String[] args) throws InterruptedException {
        //首先构造一个queue
        DelayQueue<DelayedQueueEvent> delayedQueueEvents = new DelayQueue<>();

        //然后新建task
        Thread[] threads = new Thread[MAX];
        for (int i = 0; i < MAX; i++) {
            DelayQueueTask delayQueueTask = new DelayQueueTask(i, delayedQueueEvents);
            threads[i] = new Thread(delayQueueTask);
        }

        for (int i = 0; i < MAX; i++) {
            threads[i].start();
        }

        for (int i = 0; i < MAX; i++) {
            threads[i].join();
        }

        //获取数据
        int count = 0;
        do {
            DelayedQueueEvent event;
            do {
                event = delayedQueueEvents.poll();
                if (event != null){
                    System.out.println(event.getDelay(TimeUnit.NANOSECONDS));
                    count++;
                }
            } while (event != null);

            Thread.sleep(5000);
        } while (delayedQueueEvents.size() > 0);

        System.out.println(count);
    }
}
