package com.gao.threadExcutors;

/**
 * User: wangchen.gpx
 * Date: 13-11-18
 * Time: 下午10:43
 */
public class TaskMainFixed {
    public static void main(String[] args) {
        MyServerFixed myServerFixed = new MyServerFixed();

        for (int i = 0; i < 100; i++) {
            MyTaskFixed myTaskFixed = new MyTaskFixed("task" + i);
            myServerFixed.executeTask(myTaskFixed);
        }

        myServerFixed.endTask();
    }
}
