package com.gao.first;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午1:45
 */
public class SourceLoaderClass implements Runnable {
    @Override
    public void run() {
        System.out.printf("start run source the load %s\n " , new Date());

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end run source the load %s " , new Date());
    }
}
