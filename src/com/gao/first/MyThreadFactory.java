package com.gao.first;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 下午1:12
 */
public class MyThreadFactory implements ThreadFactory {

    private AtomicInteger count;
    private String baseName;
    private List<String> statusList;

    public MyThreadFactory(String baseName) {
        count = new AtomicInteger(0);
        this.baseName = baseName;
        statusList = new ArrayList();
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r, baseName + count.getAndIncrement());
        statusList.add(String.format("Create thread %d , name is %s , on %s\n",
                thread.getId(), thread.getName(), new Date()));
        return thread;
    }

    public String getStatus(){
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = statusList.iterator();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
