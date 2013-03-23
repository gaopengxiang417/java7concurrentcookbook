package com.gao.first;

import java.io.File;

/**
 * User: wangchen.gpx
 * Date: 13-3-23
 * Time: 上午9:15
 */
public class SearchFile implements Runnable {
    private String initPath;
    private String fileName;

    public SearchFile(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                processDirectory(file);
            } catch (InterruptedException e) {
                System.out.println("end ," +Thread.currentThread().getName()+", interrupt");
            }
        }
    }

    private void processDirectory(File file) throws InterruptedException {
        if (file != null) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    processDirectory(file1);
                }else {
                    processFile(file1);
                }

                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
            }
        }
    }

    private void processFile(File file1) throws InterruptedException {
        if (file1.getName().equals(fileName)) {
            System.out.printf("search %s - find %s \n", Thread.currentThread().getName(),
                    file1.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }
}
