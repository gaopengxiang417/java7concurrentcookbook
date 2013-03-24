package com.gao.first;

import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-3-24
 * Time: 上午10:51
 */
public class SearchTaskMainTest {
    public static void main(String[] args) {
        ThreadGroup mygroup = new ThreadGroup("mygroup");
        MyResult myResult = new MyResult();
        SearchTaskRunnable searchTaskRunnable = new SearchTaskRunnable(myResult);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(mygroup, searchTaskRunnable);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.printf("count of threadgroup is : %d\n" , mygroup.activeCount());
        System.out.printf("information about the group is \n");
        mygroup.list();

        Thread[] threads = new Thread[mygroup.activeCount()];
        mygroup.enumerate(threads);
        for (Thread thread : threads) {
            System.out.printf("the thread is %s, status is %s\n" , thread.getName() , thread.getState());
        }

        waitFinish(mygroup);

        mygroup.interrupt();
    }

    private static void waitFinish(ThreadGroup mygroup) {
        while (mygroup.activeCount() > 9) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
