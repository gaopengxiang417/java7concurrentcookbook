package com.gao.concurrentcollection;

import java.util.concurrent.ThreadLocalRandom;

/**
 * User: wangchen.gpx
 * Date: 13-12-10
 * Time: 下午10:44
 */
public class ThreadLocalRandomTask implements Runnable{

    public ThreadLocalRandomTask() {
        ThreadLocalRandom.current();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s,%d\n" , name , ThreadLocalRandom.current().nextInt(10));
        }
    }
}
