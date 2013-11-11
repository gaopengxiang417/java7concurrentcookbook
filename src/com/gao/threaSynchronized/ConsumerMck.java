package com.gao.threaSynchronized;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午9:14
 */
public class ConsumerMck implements Runnable {

    private Buffer buffer;

    public ConsumerMck(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String s = buffer.get();
            processLine(s);
        }
    }

    private void processLine(String s) {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(100));
            Math.random();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
