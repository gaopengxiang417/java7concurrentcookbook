package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午4:12
 */
public class ExecuteTask implements Callable<String> {
    private String name;

    public ExecuteTask(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        int duation = (int) (Math.random() * 10);
        System.out.printf("%s sleep for %d\n" , name , duation);

        TimeUnit.SECONDS.sleep(duation);

        return "hello " + name;
    }
}
