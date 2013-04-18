package com.gao.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-4-18
 * Time: 上午10:50
 */
public class MyAtomicIntegerLock {
    private int value ;
    private Lock lock = new ReentrantLock();

    public MyAtomicIntegerLock() {
        super();
    }

    public MyAtomicIntegerLock(int value) {
        this.value = value;
    }

    public final int get(){
        lock.lock();
        try{
            return value;
        }finally {
            lock.unlock();
        }
    }

    public final void set(int value) {
        lock.lock();
        try{
            this.value = value;
        }finally {
            lock.unlock();
        }
    }

    public final int getAndSet(int value) {
        lock.lock();
        try {
            int old = this.value;
            this.value = value;
            return old;
        }finally {
            lock.unlock();
        }
    }

    public final boolean compareAndSet(int oldvalue, int newValue) {
        lock.lock();
        try {
            if (oldvalue == value) {
                value = newValue;
                return true;
            }
            return false;
        }finally {
            lock.unlock();
        }
    }

    public final int getAndIncrement() {
        lock.lock();
        try {
            return value++;
        }finally {
            lock.unlock();
        }
    }

    public final int getAndDecrement(){
        lock.lock();
        try {
            return value--;
        }finally {
            lock.unlock();
        }
    }

    public final int incrementAndGet(){
        lock.lock();
        try{
            return ++value;
        }finally {
            lock.unlock();
        }
    }

    public final int decrementAndGet(){
        lock.lock();
        try{
            return --value;
        }finally {
            lock.unlock();
        }
    }
}
