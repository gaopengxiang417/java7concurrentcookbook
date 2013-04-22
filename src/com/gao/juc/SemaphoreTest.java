package com.gao.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: wangchen.gpx
 * Date: 13-4-22
 * Time: 下午6:24
 */
public class SemaphoreTest<T> {
    public interface ObjectFactory<T>{
        T createObject();
    }

    public class Node{
        T obj;
        Node next;
    }

    final int capicity;
    final Semaphore semaphore;
    final ObjectFactory<T> factory;
    final ReentrantLock lock = new ReentrantLock();
    private Node head;
    private Node tail;

    public SemaphoreTest(ObjectFactory<T> factory, int capicity) {
        this.factory = factory;
        this.capicity = capicity;
        semaphore = new Semaphore(capicity);
        head = null;
        tail = null;
    }

    public T getObject() throws InterruptedException {
        semaphore.acquire();
        return getNextObject();
    }

    private T getNextObject() {
        lock.lock();
        try {
            if (head == null) {
                return factory.createObject();
            }
            Node t = head;
            head = head.next;
            if(head == null)
                tail = null;
            t.next = null;
            return t.obj;
        }finally {
            lock.unlock();
        }
    }

    public void putObject(T obj) {
        returnObjToPool(obj);
        semaphore.release();
    }

    private void returnObjToPool(T obj) {
        lock.lock();
        Node node = new Node();
        node.obj = obj;
        try{
            if(head == null)
                head = tail = node;
            else{
                tail.next = node;
                tail = node;
            }
        }finally {
            lock.unlock();
        }
    }
}
