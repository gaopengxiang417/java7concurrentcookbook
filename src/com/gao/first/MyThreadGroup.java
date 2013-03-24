package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午12:47
 */
public class MyThreadGroup extends ThreadGroup {
    public MyThreadGroup(String name) {
        super(name);
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("Thread %s throws exception :\n" , t.getName());
        e.printStackTrace(System.out);
        System.out.printf("terminit other thread .\n");
        interrupt();
    }
}
