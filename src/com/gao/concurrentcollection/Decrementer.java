package com.gao.concurrentcollection;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午11:02
 */
public class Decrementer implements Runnable {

    private AtomicIntegerArray array;

    public Decrementer(AtomicIntegerArray array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length(); i++) {
            array.getAndAdd(i,i + 1);
        }
    }
}
