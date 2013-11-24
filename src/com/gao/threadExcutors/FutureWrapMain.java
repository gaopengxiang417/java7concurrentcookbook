package com.gao.threadExcutors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午4:16
 */
public class FutureWrapMain {
    public static void main(String[] args) throws InterruptedException {
        List<FutureWrap> futureWrapList = new ArrayList<>();

        ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            ExecuteTask executeTask = new ExecuteTask("name" + i);
            FutureWrap futureWrap = new FutureWrap(executeTask);
            service.submit(futureWrap);
        }

        //休眠
//        TimeUnit.MILLISECONDS.sleep(100);

        //取消任务
        for (FutureWrap futureWrap : futureWrapList) {
            futureWrap.cancel(true);
        }

        //判断是否完成
        for (FutureWrap futureWrap : futureWrapList) {
            if (!futureWrap.isCancelled()) {
                try {
                    System.out.println(futureWrap.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }


        //关闭线程池
        service.shutdown();
    }
}
