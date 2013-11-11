package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午2:59
 */
public class StringBufferTest {
    public static void main(String[] args) {
        Object obj = new Object();
        obj = null;
        StringBuilder sb = new StringBuilder("test");
        System.out.println(sb.toString());
        System.out.println(sb.append(obj));
    }
}
