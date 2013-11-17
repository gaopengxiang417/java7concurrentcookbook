package com.gao.threadSyncronizedUtils;

import java.util.concurrent.Phaser;

/**
 * User: wangchen.gpx
 * Date: 13-11-17
 * Time: 上午11:14
 */
public class SearchMain {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3);

        FileSearcher javaSearch = new FileSearcher("G:\\yun_magize\\java_magnize\\java", ".pdf", phaser);
        FileSearcher goSearcher = new FileSearcher("G:\\yun_magize\\java_magnize\\go", ".pdf", phaser);
        FileSearcher cdnSearcher = new FileSearcher("G:\\yun_magize\\java_magnize\\cdn", ".pdf", phaser);

        Thread javaThread = new Thread(javaSearch);
        javaThread.start();

        Thread goThread = new Thread(goSearcher);
        goThread.start();

        Thread cdnThread = new Thread(cdnSearcher);
        cdnThread.start();


        try {
            javaThread.join();
            goThread.join();
            cdnThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finshiserd :" + phaser.isTerminated());
    }
}
