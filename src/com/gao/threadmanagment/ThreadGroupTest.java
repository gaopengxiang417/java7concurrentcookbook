package com.gao.threadmanagment;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午2:07
 * 主要测试ThreadGroup的使用
 */
public class ThreadGroupTest {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup threadGroup = new ThreadGroup("gaopeng");

        Result result = new Result();
        SearchTask searchTask = new SearchTask(result);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();

            TimeUnit.SECONDS.sleep(1);
        }

        System.out.printf("group count :%d\n" ,threadGroup.activeCount());
        System.out.printf("group information is : \n");
        threadGroup.list();

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        for (Thread thread : threads) {
            System.out.printf("thread %s , status %s\n" , thread.getName() , thread.getState());
        }

        writFinish(threadGroup);

        threadGroup.interrupt();
    }

    private static void writFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SearchTask implements Runnable{

    private Result result;

    SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("thread %s start....\n" , name);

        try {
            doTask();
            result.setName(name);
        } catch (Exception e) {
            System.out.printf("thread %s interrupted\n " , name);
            return;
        }

        System.out.printf("thread %s end ...\n" , name);
    }

    private void doTask() {
        Random random = new Random(new Date().getTime());
        int time = (int) (random.nextDouble() * 100);
        System.out.printf("thread %s , current is %d\n" , Thread.currentThread().getName() , time);

        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//结果类
class Result{
    private String name;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}
