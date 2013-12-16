package com.gao.customizeClass;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午9:06
 */
public class PriorityTaskMain {
    public static void main(String[] args) throws InterruptedException {
        //首先构建一个线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 100, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());

        //构建4个线程
        for (int i = 0; i < 4; i++) {
            PriorityTask priorityTask = new PriorityTask(i, "task " + i + " ");
            executor.execute(priorityTask);
        }

        //休眠2秒
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //再次其从4个线程
        for (int i = 4; i < 8; i++) {
            PriorityTask priorityTask = new PriorityTask(i, "task " + i + " ");
            executor.execute(priorityTask);
        }

        //关闭
        if (!executor.awaitTermination(2, TimeUnit.SECONDS)) {
            System.out.println("in await termination...");
            //关闭线程
            executor.shutdown();
            System.out.println("in shutdown method");
            if (!executor.isShutdown()) {
                System.out.println("in shutdown now method");
                List<Runnable> runnables = executor.shutdownNow();
                System.out.println(runnables.size());
            }
        }
    }
}
