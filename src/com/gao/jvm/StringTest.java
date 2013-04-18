package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-4-18
 * Time: 上午9:55
 */
public class StringTest {
    public static void main(String[] args) {
        String s = args[0];
        System.out.println(s.intern() == s);
        System.out.println("hello");
    }
}
