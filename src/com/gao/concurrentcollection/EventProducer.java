package com.gao.concurrentcollection;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午2:14
 */
public class EventProducer implements Runnable {

    private int id;

    private PriorityBlockingQueue<Event> blockingQueue;

    public EventProducer(int id, PriorityBlockingQueue<Event> blockingQueue) {
        this.id = id;
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Event event = new Event(id, i);
            blockingQueue.add(event);
        }
    }
}
