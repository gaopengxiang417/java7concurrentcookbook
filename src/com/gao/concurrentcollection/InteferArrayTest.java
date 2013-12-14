package com.gao.concurrentcollection;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午11:05
 */
public class InteferArrayTest {
    public static void main(String[] args) throws InterruptedException {
        int max = 100;
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(max);

        for (int i = 0; i < max; i++) {

            Incrementer incrementer = new Incrementer(atomicIntegerArray);
            new Thread(incrementer).start();

            Decrementer decrementer = new Decrementer(atomicIntegerArray);
            new Thread(decrementer).start();

        }

        TimeUnit.SECONDS.sleep(5);


        for (int i = 0; i < atomicIntegerArray.length(); i++) {
            System.out.println(atomicIntegerArray.get(i));
        }
    }
}
