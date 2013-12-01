package com.gao.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午10:03
 */
public class ForkJoinMain {
    public static void main(String[] args) {
        //产品生成器
        ProductGenerator productGenerator = new ProductGenerator(1000);

        //生成锁需要的产品
        List<Product> productList = productGenerator.generateProduct();

        //构造开始的任务
        MyTask myTask = new MyTask(0, productList.size(), 0.3, productList);

        //构造线程池
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //开始执行
        forkJoinPool.invoke(myTask);

        //不停的循环执行
        do {
            System.out.printf("main count %d\n" , forkJoinPool.getActiveThreadCount());
            System.out.printf("steal count %d\n" , forkJoinPool.getStealCount());
            System.out.printf("parallelism count %d\n" , forkJoinPool.getParallelism());

            try {
                TimeUnit.MILLISECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!myTask.isDone());

        //关闭
        forkJoinPool.shutdown();

        //是否关闭
        if (myTask.isCompletedNormally()) {
            System.out.printf("this task is completely normally\n");
        }

        for (Product product : productList) {
            System.out.println(product.getName() + " : " + product.getPrice());

        }

        //结束
        System.out.println("main method closed");
    }
}
