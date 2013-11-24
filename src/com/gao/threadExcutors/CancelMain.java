package com.gao.threadExcutors;

import java.util.concurrent.*;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午3:58
 */
public class CancelMain {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        CancelTask cancelTask = new CancelTask();

        //提交任务
        Future<String> future = executorService.submit(cancelTask);

        //休眠2秒
        TimeUnit.SECONDS.sleep(2);

        //取消任务
        boolean isCancelled = future.cancel(true);

        System.out.println(isCancelled);
        System.out.println("future : " + future.isCancelled());
        System.out.println("isdone : " + future.isDone());

        System.out.println("main complete");

        executorService.shutdown();

    }
}
