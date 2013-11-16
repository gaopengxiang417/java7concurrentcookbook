package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 上午11:01
 */
public class Pratinttion implements Runnable {
    private CountDownLatchTest countDownLatchTest;
    private String name;

    public Pratinttion(CountDownLatchTest countDownLatchTest, String name) {
        this.countDownLatchTest = countDownLatchTest;
        this.name = name;
    }

    @Override
    public void run() {
        int duartion = (int) (Math.random()*1000);
        try {
            Thread.sleep(duartion);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatchTest.arrive(name);
    }
}
