package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-29
 * Time: 上午10:53
 */
public class CPUProcessor {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().maxMemory() / (1024 * 1024 * 1024));
        System.out.println(Runtime.getRuntime().totalMemory() / (1024 * 1024 * 1024));
    }
}
