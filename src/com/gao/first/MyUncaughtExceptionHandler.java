package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午9:54
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("caught a exception :\n");
        System.out.printf("Thread : %d --%s\n",t.getId() , t.getName());
        System.out.printf("Exception : %s : %s\n", e.getClass(), e.getMessage());
        System.out.println("stack trace:");
        e.printStackTrace(System.out);
        System.out.printf("thread status : %s" , t.getState());
    }
}
