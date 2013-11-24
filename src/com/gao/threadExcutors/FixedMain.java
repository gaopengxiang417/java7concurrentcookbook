package com.gao.threadExcutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午2:30
 */
public class FixedMain {
    public static void main(String[] args) throws InterruptedException {
        ScheduledThreadPoolExecutor service = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        FixedTask task = new FixedTask("wangchen");

        System.out.println("main task start........");

        ScheduledFuture<?> future = service.scheduleAtFixedRate(task, 2, 3, TimeUnit.SECONDS);

        for (int i = 0; i < 10; i++) {
            long delay = future.getDelay(TimeUnit.MILLISECONDS);
            System.out.println("still has  delays " + delay);

            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        service.shutdown();

        TimeUnit.SECONDS.sleep(30);

        System.out.println("main method closed....");
    }
}
