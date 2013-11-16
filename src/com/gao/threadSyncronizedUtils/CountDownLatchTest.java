package com.gao.threadSyncronizedUtils;

import java.util.concurrent.CountDownLatch;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 上午10:54
 */
public class CountDownLatchTest implements Runnable{
    private CountDownLatch countDownLatch;

    public CountDownLatchTest() {
        this.countDownLatch = new CountDownLatch(4);

    }

    public void arrive(String name) {
        System.out.printf("%s is entering arrive....\n" , name);
        countDownLatch.countDown();
        System.out.printf("there is still %d count compliment\n" , countDownLatch.getCount());
    }


    @Override
    public void run() {
        System.out.printf("initinize wating count is %d\n" , countDownLatch.getCount());
        try {
            countDownLatch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("finally complete the wating task\n");
    }
}
