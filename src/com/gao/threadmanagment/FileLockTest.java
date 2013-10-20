package com.gao.threadmanagment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-10-20
 * Time: 上午9:58
 * sleep方法会释放CPU的时间片，但是不会释放内存
 */
public class FileLockTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new FileLock());
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

class FileLock implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s\n" , new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("the file lock has been locked");
            }
        }
    }
}
