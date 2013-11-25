package com.gao.threadExcutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:55
 */
public class RejectMain {
    public static void main(String[] args) {
        RejectTaskController controller = new RejectTaskController();

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        executorService.setRejectedExecutionHandler(controller);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new RejectTask());
        }

        //关闭
        executorService.shutdown();
        //提交一个新的任务

        executorService.submit(new RejectTask());
    }
}
