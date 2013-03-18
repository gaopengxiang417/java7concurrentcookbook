package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-18
 * Time: 上午11:21
 */
public class Calculator implements Runnable {

    private int number;

    public Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s : %d * %d = %d\n",Thread.currentThread().getName(),
                    number , i , number * i);
        }
    }
}
