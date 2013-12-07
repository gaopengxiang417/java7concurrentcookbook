package com.gao.concurrentcollection;

import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-7
 * Time: 下午10:58
 */
public class DelayedQueueEvent implements Delayed {

    private Date startDate;

    public DelayedQueueEvent(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        Date date = new Date();
        long duraction = startDate.getTime() - date.getTime();
        return unit.convert(duraction, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        long diff = this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS);
        return diff > 0 ? 1 : (diff < 0 ? -1 : 0);
    }
}
