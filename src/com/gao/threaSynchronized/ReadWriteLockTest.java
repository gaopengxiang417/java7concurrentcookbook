package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午9:10
 */
public class ReadWriteLockTest {
    public static void main(String[] args) {
        PriceInfo priceInfo = new PriceInfo();

        for (int i = 0; i < 10; i++) {
            new Thread(new ReaderRunnable(priceInfo)).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(new WriteRunnable(priceInfo)).start();
        }

    }
}
