package com.gao.threadmanagment;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-10-20
 * Time: 上午9:37
 */
public class FileSearchTest {
    public static void main(String[] args) {
        FileSearch fileSearch = new FileSearch("D:\\", "23f0f57322c4f85eb151b9f9.jpg");
        Thread thread = new Thread(fileSearch);
        thread.start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
    }
}

class FileSearch implements Runnable{

    private String filePath;

    private String fileName;

    FileSearch(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File directory = new File(filePath);

        if (directory.isDirectory()) {
            try {
                processDirectory(directory);
            } catch (InterruptedException e) {
                System.out.println("发生了中断异常");
                System.out.println(e);
            }
        }
    }

    private void processDirectory(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file);
                }else{
                    processFile(file);
                }
            }
        }

        if (Thread.interrupted()) {
            throw new InterruptedException("检查目录的时候抛出异常");
        }
    }

    private void processFile(File file) throws InterruptedException {
        String fileName1 = file.getName();
        if (fileName1.equals(fileName)) {
            System.out.printf("find file by thread %s" , Thread.currentThread().getName());
        }

        if (Thread.interrupted()) {
            throw new InterruptedException("文件抛出异常");
        }
    }
}
