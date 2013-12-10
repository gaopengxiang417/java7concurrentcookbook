package com.gao.concurrentcollection;

import java.util.Map;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * User: wangchen.gpx
 * Date: 13-12-8
 * Time: 下午4:30
 */
public class ContractMain {

    private static int Max;

    public static void main(String[] args) {
        //首先构造list
        ConcurrentSkipListMap<String, Contract> skipListMap = new ConcurrentSkipListMap<>();

        //构造task
        Max = 25;
        Thread[] threads = new Thread[Max];
        int count = 0;
        for (char i = 'A'; i < 'Z'; i++) {
            ContractTask contractTask = new ContractTask(String.valueOf(i), skipListMap);
            threads[count] = new Thread(contractTask);
            threads[count].start();
            count++;
        }

        for (int i = 0; i < Max; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //获取第一个
        System.out.println("total map size : " + skipListMap.size());
        Map.Entry<String, Contract> stringContractEntry = skipListMap.firstEntry();
        System.out.println(stringContractEntry.getKey() + ":" + stringContractEntry.getValue().getName() + "=" + stringContractEntry.getValue().getPhone());

        //获取最后一个
        System.out.println("total map size : " + skipListMap.size());
        Map.Entry<String, Contract> stringContractEntry1 = skipListMap.lastEntry();
        System.out.println(stringContractEntry1.getKey() + ":" + stringContractEntry1.getValue().getName() + "=" + stringContractEntry1.getValue().getPhone());

        System.out.println("*************华丽的分割线*************");
        //获取子元素
        ConcurrentNavigableMap<String,Contract> subMap = skipListMap.subMap("A1996", "B1002");

        Map.Entry<String, Contract> entry;
        do {
            entry = subMap.pollFirstEntry();
            if (entry != null) {
                Contract value = entry.getValue();
                System.out.println(value.getName() + ":" + value.getPhone());
            }
        } while (entry != null);
    }
}
