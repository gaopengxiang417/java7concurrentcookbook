package com.gao.forkjoin;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午1:59
 */
public class ThrowExceptionTask extends RecursiveTask<Integer> {

    //原始数组
    private int[] sources;

    //开始
    private int start;

    //结束
    private int end;

    public ThrowExceptionTask(int[] sources, int start, int end) {
        this.sources = sources;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        //首先应该操作数据
        if (end - start < 10) {
            if (start == 93)
                throw new RuntimeException("测试抛出异常,忘尘");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            int middle = (start + end ) / 2;
            ThrowExceptionTask task = new ThrowExceptionTask(sources, start, middle);
            ThrowExceptionTask task1 = new ThrowExceptionTask(sources, middle, end);

            invokeAll(task1, task1);
        }
        return 0;
    }
}
