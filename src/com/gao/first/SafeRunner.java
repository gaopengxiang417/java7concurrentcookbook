package com.gao.first;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:27
 */
public class SafeRunner implements Runnable {
    private ThreadLocal<Date> initDate = new ThreadLocal<Date>(){
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };
    @Override
    public void run() {
        System.out.printf("start thread ,thread is %d , time is %s\n" ,
                Thread.currentThread().getId() , initDate.get());

        try {
            TimeUnit.SECONDS.sleep((int)Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("end thread , thread is %d,time is %s\n" ,
                Thread.currentThread().getId() , initDate.get());
    }
}
