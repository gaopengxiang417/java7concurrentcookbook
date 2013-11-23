package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-23
 * Time: 下午5:12
 */
public class FactorialGenerator implements Callable<Integer> {

    private Integer number;

    public FactorialGenerator(Integer number) {
        this.number = number;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {
        int result = 1;
        if (number != 0 && number != 1) {
            for (int i = 2; i < number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(200);
            }
        }
        System.out.printf("%s , gengerate number :%d\n" , Thread.currentThread().getName() , number);
        return result;
    }
}
