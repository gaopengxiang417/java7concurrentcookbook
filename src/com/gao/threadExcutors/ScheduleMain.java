package com.gao.threadExcutors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午1:25
 */
public class ScheduleMain {
    public static void main(String[] args) throws InterruptedException {
        //首先创建一个service
        ScheduledThreadPoolExecutor service = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        System.out.println("start to main ...........");
        //创建5哥线程并且去运营
        //其实延迟调度任务就是把一个任务丢进一个阻塞队列,然后不停的轮询去调度
        //所以导致如果线程的延迟时间够短,那么就不会按照指定的顺序来执行了,
        for (int i = 0; i < 5; i++) {
            ScheduleTask scheduleTask = new ScheduleTask("" + i);
            service.schedule(scheduleTask, 10 - i, TimeUnit.NANOSECONDS);
        }

        service.shutdown();

        service.awaitTermination(1, TimeUnit.HOURS);
    }
}
