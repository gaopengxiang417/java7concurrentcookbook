package com.gao.threadmanagment;

import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午2:30
 */
public class ThreadGroupUncaughtExceptionHandlerTest {
    public static void main(String[] args) {
        MyThreadGroup threadGroup = new MyThreadGroup("wangchen");
        MyTask myTask = new MyTask();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(threadGroup, myTask);
            thread.start();
        }
    }
}

class MyTask implements Runnable{
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
        while (true) {
            System.out.printf("thread %s , time %s\n" , Thread.currentThread().getName() , new Date());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int i = Integer.parseInt("gg");
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("Thread %s interruped..\n" , Thread.currentThread().getName());
                return;
            }
        }
    }
}

class MyThreadGroup extends ThreadGroup{
    MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("thread %s throw exception\n" , t.getName());
        e.printStackTrace();
        interrupt();
    }
}
