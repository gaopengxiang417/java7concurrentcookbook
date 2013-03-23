package com.gao.first;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午1:49
 */
public class SourceLoaderMainTest {
    public static void main(String[] args) {
        SourceLoaderClass sourceLoaderClass = new SourceLoaderClass();
        Thread sourceThread = new Thread(sourceLoaderClass);

        NetWorkConnectClass netWorkConnectClass = new NetWorkConnectClass();
        Thread netThread = new Thread(netWorkConnectClass);

        sourceThread.start();
        netThread.start();

//        TimeUnit.SECONDS.sleep();

        try {
            sourceThread.join();
            netThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end all the method");
    }
}
