package com.gao.first;

import java.util.Date;
import java.util.Deque;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 下午2:18
 */
public class CleanerClass extends Thread {

    private Deque<EventClass> deque;

    public CleanerClass(Deque<EventClass> deque) {
        this.deque = deque;
        setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            clean(date);
        }
    }

    private void clean(Date date) {
        long difference;
        boolean isdelete = false;
        if (deque.isEmpty() || deque.size() == 0) {
            return;
        }
        do {
            EventClass last = deque.getLast();
            Date date1 = last.getDate();
            difference = date.getTime()  - date1.getTime();
            if (difference > 10000) {
                System.out.println("cleaner:"+last);
                deque.removeLast();
                isdelete = true;
            }
        } while (difference > 10000);

        if (isdelete) {
            System.out.println("cleaner , the size of the queue:"+deque.size());
        }
    }
}
