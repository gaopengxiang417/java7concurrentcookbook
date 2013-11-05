package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:11
 */
public class WaitNotifyTest {
    public static void main(String[] args) {
        DateStorage dateStorage = new DateStorage();

        Thread producer = new Thread(new Producer(dateStorage));
        Thread consumer = new Thread(new Consumer(dateStorage));

        producer.start();
        consumer.start();
    }
}
