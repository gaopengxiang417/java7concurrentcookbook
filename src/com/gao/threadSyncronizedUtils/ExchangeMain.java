package com.gao.threadSyncronizedUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * User: wangchen.gpx
 * Date: 13-11-17
 * Time: 上午11:48
 */
public class ExchangeMain {
    public static void main(String[] args) {
        List<String> producerList = new ArrayList();
        List<String> consumerList = new ArrayList();

        Exchanger<List<String>> objectExchanger = new Exchanger<>();

        new Thread(new ProducerExchange(producerList , objectExchanger)).start();
        new Thread(new ConsumerExchange(consumerList , objectExchanger)).start();
    }
}
