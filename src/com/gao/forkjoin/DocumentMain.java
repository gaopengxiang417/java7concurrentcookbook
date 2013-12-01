package com.gao.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午11:09
 */
public class DocumentMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DocumentMock documentMock = new DocumentMock();

        String[][] strings = documentMock.generageDocument(100, 1000, "the");


        DocumentTask documentTask = new DocumentTask(0, 100, strings, "the");

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.execute(documentTask);


        do {
            System.out.printf("thread count :%d\n" , forkJoinPool.getActiveThreadCount());
            System.out.printf("steal count : %d\n" , forkJoinPool.getStealCount());
            System.out.printf("parallelism : %d\n" , forkJoinPool.getParallelism());
        } while (!documentTask.isCompletedNormally());

        Integer integer = documentTask.get();
        System.out.println("total count : " + integer);

        forkJoinPool.shutdown();

        forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
