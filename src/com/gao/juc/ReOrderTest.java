package com.gao.juc;

/**
 * User: wangchen.gpx
 * Date: 13-4-10
 * Time: 上午9:02
 * 在多线程下，会出现指令的冲排序
 */
public class ReOrderTest {
    static int  a = 0 , b = 0 , x = 0 , y = 0;
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            a = b = x = y = 0;
            Thread one = new Thread() {
                @Override
                public void run() {
                    b = 1;
                    x = a;
                }
            };

            Thread two = new Thread() {
                @Override
                public void run() {
                    a = 1;
                    y = b;
                }
            };

            one.start();
            two.start();
            one.join();
            two.join();

            System.out.println(x + " : " + y);
        }
    }
}
