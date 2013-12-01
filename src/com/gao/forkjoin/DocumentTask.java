package com.gao.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RecursiveTask;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午10:52
 */
public class DocumentTask extends RecursiveTask<Integer> {
    //开始行数
    private int start;

    //结束行数
    private int end;

    //数据元
    private String[][] documents;

    //寻找的单词
    private String word;

    public DocumentTask(int start, int end, String[][] documents, String word) {
        this.start = start;
        this.end = end;
        this.documents = documents;
        this.word = word;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (end - start < 10)
            try {
                result = processLines();
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        else {
            int middle = (start + end) / 2;
            DocumentTask startTask = new DocumentTask(start, middle, documents, word);
            DocumentTask endTask = new DocumentTask(middle, end, documents, word);

            invokeAll(startTask, endTask);

            try {
                result = groupLines(startTask.get(), endTask.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    private int groupLines(Integer start, Integer end) {
        Integer tmp = 0;
        tmp = start + end;
        return tmp;
    }

    private int processLines() throws ExecutionException, InterruptedException {
        List<LineTask> list = new ArrayList<>(end - start);
        for (int i = start; i < end; i++) {
            LineTask lineTask = new LineTask(0, documents[i].length, documents[i], word);
            list.add(lineTask);
        }

        invokeAll(list);

        int count = 0;
        for (LineTask lineTask : list) {
            count += lineTask.get();
        }
        return count;
    }
}
