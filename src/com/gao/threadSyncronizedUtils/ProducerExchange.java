package com.gao.threadSyncronizedUtils;

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * User: wangchen.gpx
 * Date: 13-11-17
 * Time: 上午11:39
 */
public class ProducerExchange implements Runnable {

    private List<String> buffer;

    private Exchanger<List<String>> exchanger;

    public ProducerExchange(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;
        for (int i = 0; i < 10; i++) {
            System.out.printf("producer : cycle %d\n" , cycle);
            for (int j = 0; j < 10; j++) {
                    String message = "event " + (i * 10 +j);
                System.out.printf("producer : %s\n" , message);
                buffer.add(message);
            }

            List<String> result = null;
            try {
                result = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("producer size : %d\n" , result.size());
            cycle++;
        }
    }
}
