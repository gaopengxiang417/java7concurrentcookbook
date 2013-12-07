package com.gao.concurrentcollection;

import java.util.Date;
import java.util.concurrent.DelayQueue;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午11:03
 */
public class DelayQueueTask implements Runnable {

    private int id;

    private DelayQueue<DelayedQueueEvent> delayedQueueEvents;

    public DelayQueueTask(int id, DelayQueue<DelayedQueueEvent> delayedQueueEvents) {
        this.id = id;
        this.delayedQueueEvents = delayedQueueEvents;
    }

    @Override
    public void run() {
        Date date = new Date();

        Date lastDate = new Date(date.getTime() + id * 1000);
        for (int i = 0; i < 1000; i++) {
            DelayedQueueEvent delayedQueueEvent = new DelayedQueueEvent(lastDate);
            delayedQueueEvents.put(delayedQueueEvent);
        }

    }
}
