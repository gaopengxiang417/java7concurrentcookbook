package com.gao.juc;

/**
 * User: wangchen.gpx
 * Date: 13-4-10
 * Time: 上午10:19
 */
public class NullPointerTest {
    public static String hello = " hello";

    public static void main(String[] args) {
        NullPointerTest test = null;
        System.out.println(test.hello);
    }
}
