package com.gao.concurrentcollection;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午2:16
 */
public class PriorityBlockQueueMain {
    public static void main(String[] args) throws InterruptedException {

        PriorityBlockingQueue<Event> blockingQueue = new PriorityBlockingQueue<>();

        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new EventProducer(i, blockingQueue));
            threads[i] = thread;
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            threads[i].join();
        }

        //查看结果
        for (int i = 0; i < 5 * 1000; i++) {
            Event poll = blockingQueue.poll();
            System.out.println(poll.getId() + " : " + poll.getPriority());
        }

    }
}
