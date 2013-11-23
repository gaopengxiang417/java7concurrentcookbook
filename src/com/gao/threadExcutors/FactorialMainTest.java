package com.gao.threadExcutors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: wangchen.gpx
 * Date: 13-11-23
 * Time: 下午5:14
 */
public class FactorialMainTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Random random = new Random();

        List<Future<Integer>> futureList = new ArrayList<>();

        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(10);
            FactorialGenerator factorialGenerator = new FactorialGenerator(number);
            futureList.add(executorService.submit(factorialGenerator));
        }

        //判断是否已经结束
        while (true) {
            int count = 0;
            int total = futureList.size();

            for (Future<Integer> future : futureList) {
                if (future.isDone()) {
                    count++;
                }
            }

            if (count == total)
                break;
        }

        System.out.println("complete the job.............");
        //输出结果
        for (Future<Integer> future : futureList) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
