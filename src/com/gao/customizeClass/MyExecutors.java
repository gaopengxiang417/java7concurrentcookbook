package com.gao.customizeClass;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * User: wangchen.gpx
 * Date: 13-12-15
 * Time: 下午11:10
 */
public class MyExecutors extends ThreadPoolExecutor {
    /**
     * 用来存储时间
     */
    private ConcurrentHashMap<Integer, Date> param;

    public MyExecutors(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                       TimeUnit unit, LinkedBlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        this.param = new ConcurrentHashMap<>();
    }

    @Override
    public void shutdown() {
        System.out.println("my executors is going to shutdown.....");
        System.out.println("complete count :" + getCompletedTaskCount());
        System.out.println("active count :" + getActiveCount());
        System.out.println("pending count :" + getQueue().size());
        //关闭
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        System.out.println("my executors is going to shutdown.....");
        System.out.println("complete count :" + getCompletedTaskCount());
        System.out.println("active count :" + getActiveCount());
        System.out.println("pending count :" + getQueue().size());
        //立即关闭
        return super.shutdownNow();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.printf("myexecutor ,a task %s is going to start %d\n" ,
                t.getName() , r.hashCode());
        param.put(r.hashCode(), new Date());
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        System.out.println("*********************************");
        System.out.println("task is going to finish ");

        Date before = param.remove(r.hashCode());
        Date now = new Date();
        System.out.println("consume time is " + (now.getTime() - before.getTime()));
        System.out.println("*********************");
    }
}
