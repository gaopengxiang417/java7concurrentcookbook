package com.gao.threadmanagment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-10-28
 * Time: 下午9:20
 * <hr></hr>
 * 线程{@code Thread} 的 {@link Thread#join()} 方法
 * 该方法会使当前线程等待调用线程的结束
 * <hr></hr>
 */
public class ThreadJoinTest {
    public static void main(String[] args) {
        Thread netThread = new Thread(new NetwordLoader());
        Thread sourceThread = new Thread(new DataSourceLoader());

        netThread.start();
        sourceThread.start();

        try {
            netThread.join();
            sourceThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end main thread");
    }
}

class NetwordLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s start execute thread netword,%s\n" , Thread.currentThread().getName() , new Date());

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s end execute thread netword,%s\n" , Thread.currentThread().getName() , new Date());

    }
}

class DataSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("%s start execute thread datasource,%s\n" , Thread.currentThread().getName() , new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("%s end execute thread datasource,%s\n" , Thread.currentThread().getName() , new Date());
    }
}
