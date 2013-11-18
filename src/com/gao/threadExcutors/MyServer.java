package com.gao.threadExcutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午9:40
 */
public class MyServer {
    private ThreadPoolExecutor threadPoolExecutor;

    public MyServer() {
        this.threadPoolExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
    }


    public void executeTask(MyTask task) {
        System.out.printf("server:a new task arrived\n");

        threadPoolExecutor.execute(task);

        System.out.printf("core pool size:%d\n" , threadPoolExecutor.getCorePoolSize());
        System.out.printf("actrive size:%d\n" , threadPoolExecutor.getActiveCount());
        System.out.printf("complete task count:%d\n" , threadPoolExecutor.getCompletedTaskCount());

    }

    public void endTask(){
        threadPoolExecutor.shutdown();
    }
}
