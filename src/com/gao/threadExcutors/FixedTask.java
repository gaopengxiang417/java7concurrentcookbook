package com.gao.threadExcutors;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午2:29
 */
public class FixedTask implements Runnable {
    private String name;

    public FixedTask(String name) {
        this.name = name;
    }


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
        System.out.printf("%s, running at %s\n" , name , new Date());
    }
}
