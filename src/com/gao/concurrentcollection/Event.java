package com.gao.concurrentcollection;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午2:12
 */
public class Event implements Comparable<Event> {

    private int id;

    private int priority;

    public Event(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    @Override
    public int compareTo(Event o) {
        return this.priority > o.getPriority() ? 1 : (this.priority == o.getPriority() ? 0 : -1);
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}
