package com.gao.customizeClass;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-19
 * Time: 下午9:46
 */
public class MyExecuteTask implements Callable<String> {

    @Override
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String string = new Date().toString();
        System.out.println(string);
        return string;
    }
}
