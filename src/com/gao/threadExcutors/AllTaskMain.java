package com.gao.threadExcutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午1:06
 */
public class AllTaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<AllTask> taskList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            taskList.add(new AllTask("" + i));
        }

        //线程池
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        //返回对象
        List<Future<Result>> futureArrayList = new ArrayList<Future<Result>>();

        try {
            futureArrayList = executorService.invokeAll(taskList);
        } catch (InterruptedException e) {
            executorService.shutdown();
        }

        executorService.shutdown();

        //展示结果
        for (Future<Result> future : futureArrayList) {
            Result result = future.get();
            System.out.println(result.getName() + " : " + result.getValue());
        }
    }
}
