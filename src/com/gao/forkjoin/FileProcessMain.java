package com.gao.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午1:12
 */
public class FileProcessMain {
    public static void main(String[] args) throws InterruptedException {
        //构建新的任务
        FileProcessTask pdfTask = new FileProcessTask("G:\\yun_magize\\java_magnize\\Java", ".pdf");
        FileProcessTask picTask = new FileProcessTask("E:\\picture", ".jpg");
        FileProcessTask ligTask = new FileProcessTask("D:\\java_tools\\tomcat-6.0.20-hsf-SimbaPortal", ".log");

        //构建次
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //提交任务
        forkJoinPool.execute(pdfTask);
        forkJoinPool.execute(picTask);
        forkJoinPool.execute(ligTask);

        do {
            System.out.printf("active thread count : %d\n" , forkJoinPool.getActiveThreadCount());
            System.out.printf("steal count : %d\n" , forkJoinPool.getStealCount());
            System.out.printf("parallilist is %d\n" , forkJoinPool.getParallelism());
            TimeUnit.SECONDS.sleep(5);
        } while (!pdfTask.isDone() || !picTask.isDone() || !ligTask.isDone());


        //关闭线程池
        forkJoinPool.shutdown();
        //已经结束了,那么已经可以直接查看记录的个数了
        List<String> pdfList = pdfTask.join();
        System.out.println("*************pdf start *******************");
        for (String s : pdfList) {
            System.out.println(s);
        }
        System.out.println("************pdf ebd **********************");

        List<String> picList = picTask.join();
        System.out.println("***********pic start *******************");
        for (String s : picList) {
            System.out.println(s);
        }
        System.out.println("***********pic end **********************");

        List<String> ligList = ligTask.join();
        System.out.println("*****************log start ***************");
        for (String s : ligList) {
            System.out.println(s);
        }
        System.out.println("****************log end *******************");


    }
}
