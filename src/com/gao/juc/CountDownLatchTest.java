package com.gao.juc;

import java.util.concurrent.CountDownLatch;

/**
 * User: wangchen.gpx
 * Date: 13-4-19
 * Time: 上午10:17
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("running........");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        long timecount = countDownLatchTest.timecount(20, runnable);
        System.out.println("total count is : "+timecount);
    }

    public long timecount(int times, final Runnable runnable) throws InterruptedException {
        if(times < 0 )
            throw new IllegalArgumentException();

        final CountDownLatch totalLatch = new CountDownLatch(1);
        final CountDownLatch someLatch = new CountDownLatch(times);
        for (int i = 0; i < times; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        totalLatch.await();

                        runnable.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }finally {
                        someLatch.countDown();
                    }
                }
            }).start();
        }

        long start = System.nanoTime();
        totalLatch.countDown();
        someLatch.wait();
        return System.nanoTime() - start;
    }
}
