package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-6
 * Time: 下午9:34
 */
public class FairLockTest {
    public static void main(String[] args) throws InterruptedException {
        PrintBlocker printBlocker = new PrintBlocker();
        BlockRunnable blockRunnable = new BlockRunnable(printBlocker);

        for (int i = 0; i < 10; i++) {
            new Thread(blockRunnable).start();
        }

        Thread.sleep(10000);
    }
}
