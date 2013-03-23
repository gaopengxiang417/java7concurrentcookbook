package com.gao.first;

import java.util.ArrayDeque;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午2:25
 */
public class DaemonMainTest {
    public static void main(String[] args) {
        ArrayDeque<EventClass> deque = new ArrayDeque<>();

        WriterClass writerClass = new WriterClass(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writerClass);
            thread.start();
        }

        CleanerClass cleanerClass = new CleanerClass(deque);
        cleanerClass.start();

        while (!cleanerClass.isAlive()) {


            System.out.println("end the all :" + deque.size());
        }
    }
}
