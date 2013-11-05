package com.gao.threaSynchronized;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午9:08
 */
public class WriteRunnable implements Runnable {
    private PriceInfo priceInfo;

    public WriteRunnable(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        System.out.printf("%s,start to change price\n" , Thread.currentThread().getName());

        priceInfo.changePrice(Math.random() * 10 , Math.random() * 13);

        System.out.printf("%s,end to change price\n" , Thread.currentThread().getName());
    }
}
