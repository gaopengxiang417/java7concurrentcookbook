package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-19
 * Time: 上午9:36
 */
public class CalculatorOne implements Runnable {
    private int number;

    public CalculatorOne(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.printf("%s  calulator %d * %d = %d \n",
                    Thread.currentThread().getName(), i, number, i * number);
        }
    }
}
