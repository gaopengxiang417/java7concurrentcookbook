package com.gao.first;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:46
 */
public class SearchTaskRunnable implements Runnable {
    private MyResult result;

    public SearchTaskRunnable(MyResult result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("start :%s\n" , name);

        try {
            doTask();
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("thread interrupted : %s\n" , name);
            return;
        }
        System.out.printf("end :%s\n" , name);
    }

    private void doTask() throws InterruptedException {
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread is : %s , %d\n" , Thread.currentThread().getName() , value);
        TimeUnit.SECONDS.sleep(value);
    }
}
