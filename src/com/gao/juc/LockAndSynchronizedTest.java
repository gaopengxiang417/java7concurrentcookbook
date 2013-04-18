package com.gao.juc;

/**
 * User: wangchen.gpx
 * Date: 13-4-18
 * Time: 上午10:59
 */
public class LockAndSynchronizedTest {
    private static int value = 0;
    public static void main(String[] args) throws InterruptedException {
        int maxCount = 10;
        final int incrementCount = 10000;
        long eclipse = 0;
        for (int i = 0; i < maxCount; i++) {
            long start = System.nanoTime();
            final MyAtomicIntegerLock myAtomicIntegerLock = new MyAtomicIntegerLock(0);

            Thread[] threads = new Thread[maxCount];

            for (int j = 0; j < maxCount; j++) {
                threads[j] = new Thread(){
                    @Override
                    public void run() {
                        for (int k = 0; k < incrementCount; k++) {
                            myAtomicIntegerLock.incrementAndGet();
                        }
                    }
                };
            }

            for (int j = 0; j < threads.length; j++) {
                threads[j].start();
            }

            for (int j = 0; j < threads.length; j++) {
                threads[j].join();
            }

            long end = System.nanoTime();

            eclipse += (end - start);
        }

        System.out.println("cost time one is : " +eclipse);
        System.out.println();

        eclipse = 0;
        final Object lock = new Object();
        value = 0;
        for (int i = 0; i < maxCount; i++) {

            long start = System.nanoTime();
            Thread[] threads = new Thread[maxCount];
            for (int j = 0; j < maxCount; j++) {
                threads[j] = new Thread(){
                    @Override
                    public void run() {
                        for (int k = 0; k < incrementCount; k++) {
                            synchronized (lock) {
                                value++;
                            }
                        }
                    }
                };
            }

            for (int j = 0; j < maxCount; j++) {
                threads[j].start();
            }
            for (int j = 0; j < maxCount; j++) {
                threads[j].join();
            }

            long end = System.nanoTime();
            eclipse += (end - start);
        }

        System.out.println("second count : "+eclipse);
    }
}
