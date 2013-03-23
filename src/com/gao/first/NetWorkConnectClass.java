package com.gao.first;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午1:48
 */
public class NetWorkConnectClass implements Runnable {
    @Override
    public void run() {
        System.out.printf("start the network %s" , new Date());

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end the network %s\n ", new Date());
    }
}
