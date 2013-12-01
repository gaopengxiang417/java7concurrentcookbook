package com.gao.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午2:27
 */
public class CancelTask extends RecursiveTask<Integer> {
    private int[] arrays;

    private int start;

    private int end;

    private int number;

    private TaskManager taskManager;

    private static final int NO_FOUNDED = -1;

    public CancelTask(int[] arrays, int start, int end, int number, TaskManager taskManager) {
        this.arrays = arrays;
        this.start = start;
        this.end = end;
        this.number = number;
        this.taskManager = taskManager;
    }

    @Override
    protected Integer compute() {
        if (end - start < 10) {
            for (int i = start; i < end; i++) {
                if (arrays[i] == number) {
                    System.out.printf("number %d has founded at %d\n" , number , i);
                    taskManager.cancelTask(this);
                    return i;
                }else{
                    int middle = (start + end) / 2;
                    CancelTask startTask = new CancelTask(arrays, start, middle, number, taskManager);
                    CancelTask endTask = new CancelTask(arrays, middle, end , number, taskManager);

                    taskManager.addTask(startTask);
                    taskManager.addTask(endTask);

                    startTask.fork();
                    endTask.fork();

                    //获取结果
                    Integer firstResult = startTask.join();
                    if (firstResult != NO_FOUNDED)
                        return firstResult;
                    Integer secondResult = endTask.join();
                    if (secondResult != NO_FOUNDED)
                        return secondResult;
                }
            }
        }
        return NO_FOUNDED;
    }

    public void writeMessage() {
        System.out.printf("cancel task from %d  to %d\n" , start ,end);
    }
}
