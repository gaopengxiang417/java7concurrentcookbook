package com.gao.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午10:58
 */
public class LineTask extends RecursiveTask<Integer> {
    //开始列数
    private int start;

    //结束列数
    private int end;

    //列
    private String[] strings;

    //寻找的单词
    private String word;

    public LineTask(int start, int end, String[] strings, String word) {
        this.start = start;
        this.end = end;
        this.strings = strings;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int count = 0;
        if (end - start < 100)
            count = processColumns();
        else {
            int middle = (start + end) / 2;
            LineTask startTask = new LineTask(start, middle, strings, word);
            LineTask endTask = new LineTask(middle, end, strings, word);

            invokeAll(startTask, endTask);

            try {
                count = groupResult(startTask.get(), endTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    private int processColumns() {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (strings[i].equals(word))
                count++;
        }
        return count;
    }

    private Integer groupResult(Integer integer, Integer integer1) {
        Integer temp ;
        temp = integer + integer1;
        return temp;
    }
}
