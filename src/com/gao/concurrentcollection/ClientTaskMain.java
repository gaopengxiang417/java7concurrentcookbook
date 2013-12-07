package com.gao.concurrentcollection;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-4
 * Time: 下午10:46
 */
public class ClientTaskMain {
    public static void main(String[] args) throws InterruptedException {

        //首先创建一个阻塞队列
        LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>();

        //构建线程
        ClientTask clientTask = new ClientTask(blockingDeque);
        Thread thread = new Thread(clientTask);

        thread.start();

        //主线程不停的去取
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                String take = blockingDeque.take();
                System.out.printf("main request is : %s, list size is %d\n" , take , blockingDeque.size());
                TimeUnit.MILLISECONDS.sleep(3000);
            }
        }

        System.out.println("main method closed");
    }
}
