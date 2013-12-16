package com.gao.customizeClass;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午9:01
 */
public class PriorityTask implements Runnable , Comparable<PriorityTask>{

    /**
     * 线程的优先级
     */
    private int priority;

    /**
     * 线程的名称
     */
    private String name;

    public PriorityTask(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.printf("the thread %s and priority is %d\n" , name , priority);

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete " + priority);
    }

    @Override
    public int compareTo(PriorityTask o) {
        int priority1 = o.getPriority();
        if (this.getPriority() > o.getPriority())
            return -1;
        if (this.getPriority() < o.getPriority())
            return 1;
        return 0;
    }

    public int getPriority() {
        return priority;
    }

    public String getName() {
        return name;
    }
}
