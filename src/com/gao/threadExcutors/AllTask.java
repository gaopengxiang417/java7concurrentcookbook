package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午1:03
 */
public class AllTask implements Callable<Result> {

    private String name;

    public AllTask(String name) {
        this.name = name;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Result call() throws Exception {
        System.out.printf("%s start to task\n" , name);

        //随机休息
        int duartion = (int) (Math.random()*1000);
        TimeUnit.MILLISECONDS.sleep(duartion);

        //随机生成数据返回
        int count = 0;
        for (int i = 0; i < 5; i++) {
            count += Math.random()*100;
        }

        Result result = new Result(name, count);
        return result;
    }
}
