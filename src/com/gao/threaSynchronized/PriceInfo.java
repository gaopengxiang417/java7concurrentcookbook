package com.gao.threaSynchronized;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:52
 */
public class PriceInfo {
    private double price1;
    private double price2;
    private ReentrantReadWriteLock lock;

    public PriceInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double readPrice1(){
        lock.readLock().lock();
        double temp = price1;
        lock.readLock().unlock();
        return temp;
    }

    public double readPrice2(){
        lock.readLock().lock();
        double temp = price2;
        lock.readLock().unlock();
        return temp;
    }

    public void changePrice(double price1, double price2) {
        lock.writeLock().lock();
        this.price1 = price1;
        this.price2 = price2;
        lock.writeLock().unlock();
    }
}
