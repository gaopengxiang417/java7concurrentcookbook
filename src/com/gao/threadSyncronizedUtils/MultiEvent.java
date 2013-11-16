package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 上午11:03
 */
public class MultiEvent {
    public static void main(String[] args) {
        CountDownLatchTest countDownLatchTest = new CountDownLatchTest();
        new Thread(countDownLatchTest).start();

        for (int i = 0; i < 4; i++) {
            new Thread(new Pratinttion(countDownLatchTest , "down"+i)).start();
        }

        System.out.println("donw.............");
    }
}
