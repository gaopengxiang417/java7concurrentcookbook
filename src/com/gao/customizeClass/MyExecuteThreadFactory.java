package com.gao.customizeClass;

import java.util.concurrent.ThreadFactory;

/**
 * User: wangchen.gpx
 * Date: 13-12-19
 * Time: 下午9:43
 */
public class MyExecuteThreadFactory implements ThreadFactory {
    /**
     * 生成线程的前缀
     */
    private String prefix;

    private int count;

    public MyExecuteThreadFactory(String prefix) {
        this.prefix = prefix;
        count = 1;
    }

    @Override
    public Thread newThread(Runnable r) {
        MyExecuteThread myExecuteThread = new MyExecuteThread(r, prefix + count++);
        return myExecuteThread;
    }
}
