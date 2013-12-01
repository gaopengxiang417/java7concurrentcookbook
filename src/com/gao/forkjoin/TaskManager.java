package com.gao.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinTask;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午2:23
 */
public class TaskManager {

    private List<ForkJoinTask<Integer>>  taskList;

    public TaskManager() {
        this.taskList = new ArrayList<>();
    }


    public void addTask(ForkJoinTask task) {
        taskList.add(task);
    }

    public void cancelTask(ForkJoinTask task) {
        for (ForkJoinTask<Integer> forkJoinTask : taskList) {
            if (task != forkJoinTask)
                forkJoinTask.cancel(true);
            ((CancelTask)task).writeMessage();
        }
    }
}
