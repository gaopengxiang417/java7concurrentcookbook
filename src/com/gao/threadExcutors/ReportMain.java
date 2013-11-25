package com.gao.threadExcutors;

import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:34
 */
public class ReportMain {
    public static void main(String[] args) throws InterruptedException {
        //首先构造一个service用来执行任务
        ExecutorService service = Executors.newCachedThreadPool();

        //构造一个completetionService
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(service);

        //构造线程
        ReportRequest reportRequest = new ReportRequest("request", completionService);
        Thread requestThread = new Thread(reportRequest);

        ReportRecivier reportRecivier = new ReportRecivier(completionService);
        Thread reciverThread = new Thread(reportRecivier);

        //开始执行
        requestThread.start();
        reciverThread.start();

        /*//等待执行完毕
        try {
            requestThread.join();
            reciverThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
*/
        Thread.sleep(5000);
        //关闭线程池
        service.shutdown();

        try {
            service.awaitTermination(4 , TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        reportRecivier.setDone(true);
    }
}
