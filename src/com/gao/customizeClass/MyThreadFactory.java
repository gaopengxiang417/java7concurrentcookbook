package com.gao.customizeClass;

import java.util.concurrent.ThreadFactory;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午10:13
 */
public class MyThreadFactory implements ThreadFactory {

    /**
     * 线程的前缀
     */
    private String prefix;

    /**
     * 线程的个数
     */
    private int count;

    public MyThreadFactory(String prefix) {
        this.prefix = prefix;
        this.count = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        MyThread myThread = new MyThread(r, prefix + count);
        count++;
        return myThread;
    }
}
