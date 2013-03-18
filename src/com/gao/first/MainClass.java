package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-18
 * Time: 上午11:26
 */
public class MainClass {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Calculator calculator = new Calculator(i);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }
}
