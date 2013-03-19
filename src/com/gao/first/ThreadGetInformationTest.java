package com.gao.first;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * User: wangchen.gpx
 * Date: 13-3-19
 * Time: 上午9:38
 */
public class ThreadGetInformationTest {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        //修改线程的优先级
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new CalculatorOne(i));
            threads[i] = thread;
            if (i % 2 == 0) {
                thread.setPriority(Thread.MAX_PRIORITY);
            }else{
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            thread.setName("Thread :" + i);
        }

        //构建一个printwriter
        try(FileWriter fileWriter = new FileWriter("D:/a.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter)) {

            //显示线程的状态
            for (int i = 0; i < 10; i++) {
                printWriter.println("main: status of thread "+i+":"+threads[i].getState());
                states[i] = threads[i].getState();
            }

            //开始执行这10个线程
            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish = false;
            while (!finish) {
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != states[i]) {
                        writeInfo(printWriter,threads[i],states[i]);
                        states[i] = threads[i].getState();
                    }
                }
                finish = true;
                for (int i = 0; i < 10; i++) {
                    finish = finish && (threads[i].getState() == Thread.State.TERMINATED);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeInfo(PrintWriter writer, Thread thread, Thread.State status) {
        writer.printf("main: id %d -- %s\n", thread.getId(), thread.getName());
        writer.printf("main: priority -- %d\n", thread.getPriority());
        writer.printf("main : old status ---%s\n", status);
        writer.printf("main : new staus ----%s\n", thread.getState());
        writer.printf("main : *****************\n");
    }
}
