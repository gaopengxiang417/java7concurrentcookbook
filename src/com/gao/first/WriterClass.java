package com.gao.first;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午2:11
 */
public class WriterClass implements Runnable {

    private Deque<EventClass> deque;

    public WriterClass(Deque<EventClass> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            System.out.println("thread :" +Thread.currentThread().getName()+",start run...");
            EventClass eventClass = new EventClass();
            eventClass.setDate(new Date());
            eventClass.setName(String.format("thread generate the event class is %d,%d" , Thread.currentThread().getId(),i));

            deque.addFirst(eventClass);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            System.out.println("thread :" +Thread.currentThread().getName()+",end run...");
        }
    }
}
