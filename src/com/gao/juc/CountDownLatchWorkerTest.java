package com.gao.juc;

import java.util.concurrent.CountDownLatch;

/**
 * User: wangchen.gpx
 * Date: 13-4-19
 * Time: 上午11:18
 */
public class CountDownLatchWorkerTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(20);

        for (int i = 0; i < 20; i++) {
            new Thread(new WokerTest(startSignal,doneSignal)).start();
        }

        System.out.println("start to do something");
        Thread.sleep(3000);
        startSignal.countDown();
        Thread.sleep(3000);
        doneSignal.wait();

    }

    public static class WokerTest implements Runnable{
        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;

        public WokerTest(CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }

        @Override
        public void run() {
            try {
                startSignal.await();
                doWork();
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private void doWork() {
            System.out.println("doing work....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
