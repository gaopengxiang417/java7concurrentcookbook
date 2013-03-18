package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-18
 * Time: 下午5:15
 */
public class Bar {
    int a = 1;
    static int b = 2;

    public int sum(int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        new Bar().sum(3);
    }

}
