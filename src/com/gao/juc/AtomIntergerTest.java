package com.gao.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: wangchen.gpx
 * Date: 13-4-9
 * Time: 下午4:00
 */
public class AtomIntergerTest {
    public static void main(String[] args) throws InterruptedException {
        final AtomicInteger atomicInteger = new AtomicInteger();
        //调用comparandset方法，主要是测试失败的情况
        System.out.println("fail to set: "+atomicInteger.compareAndSet(2, 4));
        //调用weakCompareAndSet，成功的情况，其实底层和调用compareandset是一样的
        System.out.println("success to set ： "+atomicInteger.weakCompareAndSet(0 , 4));

        System.out.println("get method: "+atomicInteger.get());

        atomicInteger.set(0);

        System.out.println("incrementandget : "+atomicInteger.incrementAndGet());
        System.out.println("getandincrement : "+atomicInteger.getAndIncrement());

        System.out.println("getandset : "+atomicInteger.getAndSet(10));

        System.out.println("value current is :" + atomicInteger.get());

        int size = 10;
        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new Thread(){
                @Override
                public void run() {
                    atomicInteger.incrementAndGet();
                }
            };
        }

        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        /*try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        System.out.println(atomicInteger.get());
    }
}
