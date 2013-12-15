package com.gao.customizeClass;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-15
 * Time: 下午11:21
 */
public class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        TimeUnit.SECONDS.sleep(2);
        return new Date().toString();
    }
}
