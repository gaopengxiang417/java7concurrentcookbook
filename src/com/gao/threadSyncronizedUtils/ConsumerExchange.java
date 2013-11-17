package com.gao.threadSyncronizedUtils;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * User: wangchen.gpx
 * Date: 13-11-17
 * Time: 上午11:44
 */
public class ConsumerExchange implements Runnable {
    private List<String> buffer;

    private Exchanger<List<String>> exchanger;

    public ConsumerExchange(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("consumer : cycle %d\n" , cycle);
            try {
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int j = 9; j >= 0; j--) {
                String message = buffer.get(j);
                System.out.println("consumer message :" + message);
                buffer.remove(j);
            }

            cycle++;
        }

    }
}
