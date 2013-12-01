package com.gao.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午2:04
 */
public class ThrowTaskMain {
    public static void main(String[] args) {
        int[] array = new int[100];
        ThrowExceptionTask task = new ThrowExceptionTask(array, 0, 100);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.execute(task);

        //刮泥
        forkJoinPool.shutdown();

        try {
            forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (task.isCompletedAbnormally()) {
            System.out.println(task.getException());
        }

        System.out.println(task.join());
    }
}
