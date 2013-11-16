package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 下午12:44
 */
public class Grouper implements Runnable {
    private Result result;

    public Grouper(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        System.out.printf("processing the result.....\n");
        int count = 0;
        int[] data = result.getData();
        for (int i : data) {
            count += i;
        }

        System.out.printf("total result is %d\n" , count);
    }
}
