package com.gao.threadExcutors;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午9:35
 */
public class MyTask implements Runnable {

    private Date initDate;

    private String name;

    public MyTask(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("%s, task %s , created at %s\n" ,
                Thread.currentThread().getName() , name , initDate);

        System.out.printf("%s , task %s , running at %s\n" ,
                Thread.currentThread().getName() , name , new Date());

        //休眠时间
        int duration = (int) (Math.random()*10);
        System.out.printf("%s, task %s doning some work duration %d" ,
                Thread.currentThread().getName() , name , duration);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s , task %s , complete at %s\n" ,
                Thread.currentThread().getName() , name , new Date());
    }
}
