package com.gao.threaSynchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-11-6
 * Time: 下午9:19
 */
public class PrintBlocker {

    private Lock lock = new ReentrantLock(true);

    public void print(){
        lock.lock();
        try {
            int duration = (int) (Math.random() * 1000);

            System.out.printf("%s,  print job 1 %d\n" , Thread.currentThread().getName() , duration);

            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


        lock.lock();
        try {
            int duration = (int) (Math.random() + 1000);
            System.out.printf("%s, print job2 %d\n" , Thread.currentThread().getName() , duration);
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }
}
