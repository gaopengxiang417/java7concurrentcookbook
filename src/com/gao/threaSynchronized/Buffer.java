package com.gao.threaSynchronized;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-11-10
 * Time: 下午8:59
 */
public class Buffer {
    private LinkedList<String> buffer;

    private int maxSize;

    private ReentrantLock lock;

    private Condition lines;

    private Condition space;

    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.buffer = new LinkedList<>();
        this.maxSize = maxSize;
        this.lock = new ReentrantLock();
        this.lines = lock.newCondition();
        this.space = lock.newCondition();
        this.pendingLines = true;
    }

    public void insert(String line) {
        lock.lock();

        try {
            while (buffer.size() == maxSize) {
                space.await();
            }
            buffer.offer(line);

            System.out.printf("%s,insert lines %d\n", Thread.currentThread().getName(), buffer.size());

            lines.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public String get(){
        lock.lock();

        try {
            while (buffer.size() == 0 && !hasPendingLines()) {
                lines.await();
            }
            if (hasPendingLines()) {
                String poll = buffer.poll();
                System.out.printf("%s,get line %d\n" , Thread.currentThread().getName() , buffer.size());
                space.signalAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public boolean hasPendingLines(){
        return pendingLines || buffer.size() == 0;
    }

    public void setPendingLines(boolean pendingLines){
        this.pendingLines =  pendingLines;
    }
}
