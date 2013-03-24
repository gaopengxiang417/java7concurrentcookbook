package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:16
 */
public class UnsafeMainTest {
    public static void main(String[] args) {
        UnsafeRunner unsafeRunner = new UnsafeRunner();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(unsafeRunner);
            thread.start();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
