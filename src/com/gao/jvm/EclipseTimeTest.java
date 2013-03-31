package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-3-30
 * Time: 下午8:46
 */
public class EclipseTimeTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long count = 0;
        for (int i = 0; i < 10000; i++) {
            count++;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
