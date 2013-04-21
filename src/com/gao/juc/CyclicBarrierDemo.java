package com.gao.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * User: wangchen.gpx
 * Date: 13-4-21
 * Time: 下午4:28
 */
public class CyclicBarrierDemo {
    private final CyclicBarrier barrier;
    private final int count;

    public CyclicBarrierDemo(int count) {
        barrier = new CyclicBarrier(count + 1);
        this.count = count;
    }

    public void doWork(final Runnable runnable) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start to run....."+runnable.hashCode());
                runnable.run();

                try {
                    int current = barrier.await();
                    System.out.println("end block...."+runnable.hashCode());
                    doWithIndex(current);
                } catch (InterruptedException e) {
                    return;
                } catch (BrokenBarrierException e) {
                    return;
                }
            }
        }).start();
    }

    private void doWithIndex(int current) {
        if (current == count / 3) {
            System.out.println("left 30%.....");
        }else if (current == count / 2) {
            System.out.println("left 50 %........");
        }else if (current == 0) {
            System.out.println("run over");
        }
    }

    public void waitForNext(){
        try {
            barrier.await();
        } catch (InterruptedException e) {
            return;
        } catch (BrokenBarrierException e) {
            return;
        }
    }

    public static void main(String[] args) {
        final int count = 10;
        CyclicBarrierDemo cyclicBarrierDemo = new CyclicBarrierDemo(count);
        for (int i = 0; i < 100; i++) {
            cyclicBarrierDemo.doWork(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });

            if ((i + 1) % count == 0) {
                cyclicBarrierDemo.waitForNext();
            }
        }
    }
}
