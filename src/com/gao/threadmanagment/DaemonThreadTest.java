package com.gao.threadmanagment;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-10-28
 * Time: 下午9:37
 * <hr></hr>
    测试线程的{@link Thread#setDaemon(boolean)} 方法，
    如果现在只有守护线程在运行，那么JVM回终止线程，所以守护线程的优先级比较低
 * <hr></hr>
 */
public class DaemonThreadTest {
    public static void main(String[] args) {
        Deque<Event> events = new ArrayDeque<>();
        EventProducer eventProducer = new EventProducer(events);
        for (int i = 0; i < 3; i++) {
            new Thread(eventProducer).start();
        }

        new EventCleanr(events).start();

        System.out.println("end ..........");
    }
}

class EventCleanr extends Thread {
    private Deque<Event> deque;

    EventCleanr(Deque<Event> deque) {
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
        long diffence;
        boolean delete = false;

        if (deque.size() == 0)
            return;

        do {
            Event last = deque.getLast();
            diffence = date.getTime() - last.getDate().getTime();
            if (diffence > 10000) {
                System.out.printf("clean : %s\n", last.getEvent());
                deque.removeLast();
                delete = true;
            }
        } while (diffence > 10000);


        if (delete) {
            System.out.println("the size of deque is" + deque.size());
        }

    }
}

class EventProducer implements Runnable {
    private Deque<Event> queue;

    EventProducer(Deque<Event> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("%d run method\n", Thread.currentThread().getId()));

            queue.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Event {
    private Date date;

    private String event;

    Date getDate() {
        return date;
    }

    void setDate(Date date) {
        this.date = date;
    }

    String getEvent() {
        return event;
    }

    void setEvent(String event) {
        this.event = event;
    }
}
