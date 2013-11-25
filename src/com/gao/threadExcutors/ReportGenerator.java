package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:26
 */
public class ReportGenerator implements Callable<String> {
    //发送的名称
    private String name;

    //发送的标题
    private String title;

    public ReportGenerator(String name, String title) {
        this.name = name;
        this.title = title;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        int duration = (int) (Math.random()*10);
        System.out.printf("%s_%s sleep for %d\n" , name , title , duration);

        TimeUnit.SECONDS.sleep(duration);

        return name + "_" + title;
    }
}
