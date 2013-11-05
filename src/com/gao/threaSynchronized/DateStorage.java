package com.gao.threaSynchronized;

import java.util.Date;
import java.util.LinkedList;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:04
 */
public class DateStorage {
    private int maxSize;

    private LinkedList<Date> sorageList;

    public DateStorage() {
        this.maxSize = 100;
        this.sorageList = new LinkedList<>();
    }

    public synchronized void set() {
        while (maxSize == sorageList.size()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date date = new Date();
        sorageList.offerFirst(date);
        System.out.println("add:" + date);
        notifyAll();
    }

    public synchronized Date get(){
        while (sorageList.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Date poll = sorageList.poll();
        notifyAll();
        return poll;
    }
}
