package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午3:57
 */
public class CancelTask implements Callable<String> {
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        while (true) {
            System.out.println("running ......");

            TimeUnit.MILLISECONDS.sleep(500);
        }
    }
}
