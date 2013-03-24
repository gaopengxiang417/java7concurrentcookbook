package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:30
 */
public class SafeMainTest {
    public static void main(String[] args) {
        SafeRunner safeRunner = new SafeRunner();
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(safeRunner);
            thread.start();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
