package com.gao.first;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:12
 */
public class UnsafeRunner implements Runnable {

    private Date initDate;
    @Override
    public void run() {
        initDate = new Date();
        System.out.printf("start init date , thread is %d,time is %s\n" , Thread.currentThread().getId() , initDate);

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end thread , the thread is %d , and the time is %s\n" ,
                Thread.currentThread().getId() , initDate);
    }
}
