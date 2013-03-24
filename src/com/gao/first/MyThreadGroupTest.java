package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午12:53
 */
public class MyThreadGroupTest {
    public static void main(String[] args) {
        MyThreadGroup mygroup = new MyThreadGroup("mygroup");

        for (int i = 0; i < 4; i++) {
            ThrowExceptionRunnable throwExceptionRunnable = new ThrowExceptionRunnable();
            Thread thread = new Thread(mygroup,throwExceptionRunnable);
            thread.start();
        }

    }
}
