package com.gao.threadmanagment;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-10-20
 * Time: 上午10:15
 */
public class JoinMethod {
    public static void main(String[] args) {
        Thread dataThread = new Thread(new DateSourceLoader());
        Thread netThread = new Thread(new NetWorkSourceLoader());

        dataThread.start();
        netThread.start();

        try {
            dataThread.join();
            netThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("main method end %s" , new Date());
    }
}
class DateSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("beginning data source %s\n" , new Date());

        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end data source %s\n" , new Date());
    }
}

class NetWorkSourceLoader implements Runnable{
    @Override
    public void run() {
        System.out.printf("beginning network source %s\n" , new Date());

        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end network source %s\n" , new Date());
    }
}
