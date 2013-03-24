package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午9:58
 */
public class UncaughtExceptionMainTest {
    public static void main(String[] args) {
        ThrowUncaughtExceptionThread throwUncaughtExceptionThread = new ThrowUncaughtExceptionThread();
        Thread thread = new Thread(throwUncaughtExceptionThread);

        MyUncaughtExceptionHandler myUncaughtExceptionHandler = new MyUncaughtExceptionHandler();
        thread.setUncaughtExceptionHandler(myUncaughtExceptionHandler);


        thread.start();
    }
}
