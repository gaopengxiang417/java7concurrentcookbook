package com.gao.threadSyncronizedUtils;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 下午12:04
 */
public class Searcher implements Runnable{
    private int startRow;

    private int endRow;

    private MatrixMock mock;

    private Result result;

    private int number;

    private CyclicBarrier cyclicBarrier;

    public Searcher(int startRow, int endRow, MatrixMock mock,
                    Result result, int number, CyclicBarrier cyclicBarrier) {
        this.startRow = startRow;
        this.endRow = endRow;
        this.mock = mock;
        this.result = result;
        this.number = number;
        this.cyclicBarrier = cyclicBarrier;
    }


    @Override
    public void run() {
        System.out.printf("%s start process from %d to %d \n" ,
                Thread.currentThread().getName() , startRow , endRow);

        for (int i = startRow; i < endRow; i++) {
            int counter = 0;
            int[] row = mock.getRow(i);
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number)
                    counter++;
            }
            result.setData(i , counter);
        }

        System.out.printf("%s lines processed...\n" , Thread.currentThread().getName());

        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
