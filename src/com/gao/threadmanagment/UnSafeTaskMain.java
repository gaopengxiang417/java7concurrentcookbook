package com.gao.threadmanagment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午1:35
 * 这个类主要是说明如果多个Thread公用一个runnable会导致共享变量的问题
 */
public class UnSafeTaskMain {
    public static void main(String[] args) throws InterruptedException {
        UnSafeTask unSafeTask = new UnSafeTask();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unSafeTask);
            Thread.sleep(1000);
            thread.start();
        }

//        Thread.sleep(2);

        System.out.println("end............");
    }
}
class UnSafeTask implements Runnable{

    private Date start;
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
        start = new Date();
        System.out.printf("thread %d,start at %s\n" , Thread.currentThread().getId() , start);

        try {
            TimeUnit.SECONDS.sleep((long) Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("thread %d,end at %s\n" , Thread.currentThread().getId() , start);
    }
}
