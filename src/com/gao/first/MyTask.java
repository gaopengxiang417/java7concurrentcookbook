package com.gao.first;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午1:18
 */
public class MyTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
