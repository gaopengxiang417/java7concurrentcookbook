package com.gao.juc;

/**
 * User: wangchen.gpx
 * Date: 13-4-10
 * Time: 上午9:36
 */
public class ClockTest {
    public static void main(String[] args) {
        int minutes = 0;
        for (int ms = 0; ms < 60 * 60 * 1000; ms++)
            if (ms % 60 * 1000 == 0)
                minutes++;
        System.out.println(minutes);

    }
}
