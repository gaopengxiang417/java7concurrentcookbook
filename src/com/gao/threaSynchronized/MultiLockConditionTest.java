package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午9:17
 */
public class MultiLockConditionTest {
    public static void main(String[] args) {
        FileMock fileMock = new FileMock(100, 10);

        Buffer buffer = new Buffer(20);

        ProducerMock producerMock = new ProducerMock(fileMock, buffer);
        Thread producerThread = new Thread(producerMock);

        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            ConsumerMck consumerMck = new ConsumerMck(buffer);
            threads[i] = new Thread(consumerMck);
        }

        producerThread.start();
        for (Thread thread : threads) {
            thread.start();
        }

    }
}
