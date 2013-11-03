package com.gao.threadmanagment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午1:46
 * 主要是用来测试ThreadLocal这个类的特性
 */
public class SafeTaskMain {
    public static void main(String[] args) throws InterruptedException {
        SafeTask safeTask = new SafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(safeTask);
            Thread.sleep(1000);
            thread.start();
        }

        System.out.println("main task end...");
    }
}

class SafeTask implements Runnable{
    private ThreadLocal<Date> start = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.printf("thread %d ,start %s\n", Thread.currentThread().getId(), start.get());

        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("thread %d , end %s\n" , Thread.currentThread().getId() , start.get());
    }
}
