package com.gao.threadmanagment;

/**
 * User: wangchen.gpx
 * Date: 13-10-28
 * Time: 下午10:17
 */
public class DaemonTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();


        System.out.println("main method end....");
    }
}

class MyThread extends Thread{

    MyThread(){
        setDaemon(true);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("mythread is week up....");
    }
}
