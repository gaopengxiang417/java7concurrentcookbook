package com.gao.customizeClass;

import java.util.concurrent.*;

/**
 * User: wangchen.gpx
 * Date: 13-12-19
 * Time: 下午9:47
 */
public class ExecuteMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //构建线程工程
        MyExecuteThreadFactory threadFactory = new MyExecuteThreadFactory("wangchen");

        ExecutorService service = Executors.newCachedThreadPool(threadFactory);

        //构建task
        MyExecuteTask task = new MyExecuteTask();

        Future<String> future = service.submit(task);

        TimeUnit.SECONDS.sleep(2);

        if (future.isDone()) {
            String s = future.get();
            System.out.println(s);
        }

        service.shutdown();


    }
}
