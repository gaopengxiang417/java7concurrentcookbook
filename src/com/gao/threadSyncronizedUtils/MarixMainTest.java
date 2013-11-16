package com.gao.threadSyncronizedUtils;

import java.util.concurrent.CyclicBarrier;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 下午12:46
 */
public class MarixMainTest {
    public static void main(String[] args) throws InterruptedException {
        final int ROW_LENGTH = 10000;
        final int COLUMN_LENGTH = 1000;
        int number = 5;
        final int PARTITIONS = 5;
        final int PARTITION_NUMBER = 2000;
        MatrixMock matrixMock = new MatrixMock(ROW_LENGTH, COLUMN_LENGTH, number);

        Result result = new Result(ROW_LENGTH);

        Grouper grouper = new Grouper(result);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(PARTITIONS, grouper);

        Searcher[] searchers = new Searcher[PARTITIONS];
        for (int i = 0; i < PARTITIONS; i++) {
            searchers[i] = new Searcher(i * PARTITION_NUMBER ,
                    (i * PARTITION_NUMBER) + PARTITION_NUMBER ,
                    matrixMock , result , number , cyclicBarrier);

            Thread thread = new Thread(searchers[i]);
            thread.start();
        }

        Thread.sleep(100000);
        System.out.println("main closed...");
    }
}
