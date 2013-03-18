package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-18
 * Time: 下午6:33
 */
public class ThreadProperties implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"start to run:");
    }
}
