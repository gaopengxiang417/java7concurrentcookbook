package com.gao.threadExcutors;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午10:33
 */
public class MyTaskFixed  implements Runnable{
    private Date initDate;

    private String name;

    public MyTaskFixed(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("enter the thread %s\n" , Thread.currentThread().getName());

        int duration = (int) (Math.random() * 10);

        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end the thread %s\n" , Thread.currentThread().getName());
    }


}
