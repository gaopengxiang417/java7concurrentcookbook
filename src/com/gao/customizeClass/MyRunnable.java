package com.gao.customizeClass;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午10:12
 */
public class MyRunnable implements Runnable {


    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
