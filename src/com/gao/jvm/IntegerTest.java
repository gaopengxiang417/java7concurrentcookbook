package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-11-20
 * Time: 下午1:03
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer one = 23;
        Integer two = 23;

        System.out.println(one == two);

        Integer three = 128;
        Integer four = 128;
        System.out.println(three == four);
    }
}
