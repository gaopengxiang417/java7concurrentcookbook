package com.gao.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午2:35
 */
public class CanceledMain {
    public static void main(String[] args) throws InterruptedException {
        ArrayGenerator arrayGenerator = new ArrayGenerator();

        int[] arrays = arrayGenerator.generate(1000);

        TaskManager taskManager = new TaskManager();
        CancelTask cancelTask = new CancelTask(arrays, 0, 1000, 5, taskManager);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        forkJoinPool.execute(cancelTask);

        forkJoinPool.shutdown();

        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);


    }
}
