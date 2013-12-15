package com.gao.customizeClass;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-15
 * Time: 下午11:22
 */
public class MyExecutorMain {
    public static void main(String[] args) {
        //首先创建自定义的executor
        MyExecutors myExecutors = new MyExecutors(5, 10, 100, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());

        //保存线程的执行结果
        ArrayList<Future<String>> futures = new ArrayList<>();

        //开启10个线程
        for (int i = 0; i < 10; i++) {
            MyTask myTask = new MyTask();
            Future<String> future = myExecutors.submit(myTask);
            futures.add(future);
        }

        //获取前5哥线程进行查看结果
        for (int i = 0; i < 5; i++) {
            try {
                String s = futures.get(i).get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //关闭线程
        myExecutors.shutdown();


        //获取后面的5哥线程的结果
        for (int i = 5; i < 10; i++) {
            try {
                String s = futures.get(i).get();
                System.out.println(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        //关闭线程
        try {
            myExecutors.awaitTermination(10, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
