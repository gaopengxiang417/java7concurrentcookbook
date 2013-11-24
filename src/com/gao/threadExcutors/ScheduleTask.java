package com.gao.threadExcutors;

import java.util.Date;
import java.util.concurrent.Callable;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午1:24
 */
public class ScheduleTask implements Callable<String> {

    private String name;

    public ScheduleTask(String name) {
        this.name = name;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        System.out.printf("%s , start at %s\n" , name , new Date());
        return "hello world";
    }
}
