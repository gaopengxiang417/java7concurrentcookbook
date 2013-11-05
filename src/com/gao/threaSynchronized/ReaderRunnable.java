package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午9:06
 */
public class ReaderRunnable implements Runnable {
    private PriceInfo priceInfo;

    public ReaderRunnable(PriceInfo priceInfo) {
        this.priceInfo = priceInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s,price1:%9.2f\t,",Thread.currentThread().getName() , priceInfo.readPrice1());
            System.out.printf("%s,price2:%9.2f\n" ,Thread.currentThread().getName() , priceInfo.readPrice2());
        }
    }
}
