package com.gao.threadExcutors;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:53
 */
public class RejectTask implements Runnable {
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
        int duration = (int) (Math.random() * 10);
        System.out.printf("%s sleep for %d\n" , Thread.currentThread().getName() , duration);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s is endding\n" , Thread.currentThread().getName());
    }
}
