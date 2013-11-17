package com.gao.threadSyncronizedUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-11-17
 * Time: 上午10:58
 */
public class FileSearcher implements Runnable {

    private String initPath;//初始路径

    private String end;//文件结尾

    private List<String> result;//搜索的结果

    private Phaser phaser;//控制同步

    public FileSearcher(String initPath, String end, Phaser phaser) {
        this.initPath = initPath;
        this.end = end;
        this.phaser = phaser;
        this.result = new ArrayList<>();
    }

    public void processDirctory(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    processDirctory(file1);
                }else {
                    processFile(file1);
                }
            }
        }
    }

    private void processFile(File file1) {
        if (file1.isFile() && file1.getAbsolutePath().endsWith(".pdf")) {
            result.add(file1.getAbsolutePath());
        }
    }

    public void filterResult() {
        List<String> newResult = new ArrayList<>();
        long now = new Date().getTime();

        for (String file : result) {
            File tempFile = new File(file);
            long last = tempFile.lastModified();
            if (now - last <= TimeUnit.MILLISECONDS.convert(30 , TimeUnit.DAYS)){
                newResult.add(file);
            }
        }
        result = newResult;
    }

    public boolean checkResult() {
        if (result.isEmpty()) {
            System.out.printf("%s check result 0 , phaser is %d \n" , Thread.currentThread().getName() , phaser.getPhase());
            System.out.printf("%s check end phaser is %d\n" , Thread.currentThread().getName() , phaser.getPhase());
            phaser.arriveAndDeregister();
            return false;
        }else{
            System.out.printf("%s find result %d, phaser is %d\n" , Thread.currentThread().getName() ,
                    result.size() , phaser.getPhase());
            phaser.arriveAndAwaitAdvance();
            return true;
        }
    }

    public void showInfo(){
        for (String s : result) {
            File file = new File(s);
            System.out.printf("%s : %s\n" , Thread.currentThread().getName() , file.getAbsolutePath());
        }
        phaser.arriveAndAwaitAdvance();
    }

    @Override
    public void run() {
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s starting to \n" , Thread.currentThread().getName());

        File file = new File(initPath);
        if (file.isDirectory()) {
            processDirctory(file);
        }

        if (!checkResult()) {
            return;
        }

        filterResult();

        if (!checkResult()) {
            return;
        }

        showInfo();
        phaser.arriveAndAwaitAdvance();
        System.out.printf("%s complete the work\n",Thread.currentThread().getName());
    }
}
