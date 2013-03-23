package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 上午9:57
 */
public class SleepMainTest {
    public static void main(String[] args) {
        SleepRunnable sleepRunnable = new SleepRunnable();
        Thread thread = new Thread(sleepRunnable);

        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}
