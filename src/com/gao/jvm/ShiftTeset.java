package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-4-2
 * Time: 下午2:51
 */
public class ShiftTeset {
    public static void main(String[] args) {
        System.out.println(1 << 16);
        System.out.println((1 << 16) >>> 16);
    }
}
