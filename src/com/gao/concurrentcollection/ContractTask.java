package com.gao.concurrentcollection;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * User: wangchen.gpx
 * Date: 13-12-8
 * Time: 下午4:28
 */
public class ContractTask implements Runnable {
    private String id;

    private ConcurrentSkipListMap<String, Contract> listMap;

    public ContractTask(String id, ConcurrentSkipListMap<String, Contract> listMap) {
        this.id = id;
        this.listMap = listMap;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Contract contract = new Contract(id, String.valueOf(i + 1000));
            listMap.put(id + contract.getPhone(), contract);
        }
    }
}
