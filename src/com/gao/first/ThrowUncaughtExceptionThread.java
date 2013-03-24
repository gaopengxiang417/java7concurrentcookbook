package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午9:57
 */
public class ThrowUncaughtExceptionThread implements Runnable {
    @Override
    public void run() {
        throw new NumberFormatException("这个是一个测试的专门跑出异常的程序");
    }
}
