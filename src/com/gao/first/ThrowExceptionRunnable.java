package com.gao.first;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午12:50
 */
public class ThrowExceptionRunnable implements Runnable {
    @Override
    public void run() {
        int result;
        long id = Thread.currentThread().getId();
        while (true) {
            result = (int) (id / (int) (new Random().nextDouble()* 100));
            System.out.printf("thread %s and the number is %f \n" , Thread.currentThread().getName() , result);

            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("thread %s is interrupted\n" , Thread.currentThread().getName());
                return;
            }
        }
    }
}
