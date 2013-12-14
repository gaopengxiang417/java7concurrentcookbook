package com.gao.concurrentcollection;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午10:55
 */
public class Incrementer implements Runnable {

    private AtomicIntegerArray array;

    public Incrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndIncrement(i);
        }
    }
}
