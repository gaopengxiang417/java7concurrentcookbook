package com.gao.threadExcutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午10:36
 */
public class MyServerFixed {
    private ThreadPoolExecutor executor;

    public MyServerFixed() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
    }

    public void executeTask(MyTaskFixed task){
        executor.execute(task);

        System.out.println("core thread pool size :" + executor.getCorePoolSize());
        System.out.println("active thread pool size :" + executor.getActiveCount());
        System.out.println("completeed thread pool size:" + executor.getCompletedTaskCount());
    }

    public void endTask(){
        executor.shutdown();
    }
}
