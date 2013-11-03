package com.gao.threadmanagment;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午7:35
 */
public class ThreadFactoryTest {
    public static void main(String[] args) {
        MyThreadFactory threadFactory = new MyThreadFactory("wang");

        for (int i = 0; i < 10; i++) {
            Thread thread = threadFactory.newThread(new Task());
            thread.start();
        }

        System.out.println(threadFactory.getStatis());
    }
}

class MyThreadFactory implements ThreadFactory{
    private int counter;
    private String name;
    private List<String> stats;

    MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<>();
    }

    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     *         create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, name + "-thread-" + counter);
        counter++;
        stats.add(String.format("create thread %d with name %s on %s\n" , thread.getId() ,
                thread.getName() , new Date()));
        return thread;
    }

    public String getStatis(){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = stats.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            stringBuilder.append(next);
        }

        return stringBuilder.toString();
    }
}

class Task implements Runnable{
    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
