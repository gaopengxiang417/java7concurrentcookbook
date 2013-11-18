package com.gao.threadExcutors;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午9:58
 */
public class TaskMain {
    public static void main(String[] args) {
        MyServer myServer = new MyServer();

        for (int i = 0; i < 100; i++) {
            MyTask myTask = new MyTask("task" + i);
            myServer.executeTask(myTask);
        }

        myServer.endTask();


    }
}
