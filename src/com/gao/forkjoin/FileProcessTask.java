package com.gao.forkjoin;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午12:56
 * 搜索指定后缀的文件列表
 */
public class FileProcessTask extends RecursiveTask<List<String>> {

    //需要搜索额路径
    private String path;

    //需要搜索的文件的后缀
    private String suffix;

    public FileProcessTask(String path, String suffix) {
        this.path = path;
        this.suffix = suffix;
    }

    @Override
    protected List<String> compute() {
        if (path == null || path.isEmpty() || suffix == null || suffix.isEmpty())
            throw new IllegalArgumentException("传入的参数不能为空");

        Path path = Paths.get(this.path);

        //用来返回的搜索到的文件的具体的路径
        List<String> fileList = new ArrayList<>();
        //创建的任务
        List<FileProcessTask> taskList = new ArrayList<>();
        //如果是目录的话
        File file = new File(this.path);
        File[] files = file.listFiles();
        if (files != null) {
            for (File tempFile : files) {
                if (tempFile.isDirectory()) {
                    FileProcessTask fileProcessTask = new FileProcessTask(tempFile.getAbsolutePath(), suffix);
                    fileProcessTask.fork();
                    taskList.add(fileProcessTask);
                }else {
                    if (tempFile.getName().endsWith(suffix))
                        fileList.add(tempFile.getAbsolutePath());
                }
            }
        }
        /*if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
            try(DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){
                for (Path tempPath : directoryStream) {
                    //如果是文件并且后缀相同就加入列表
                    if (Files.isRegularFile(tempPath, LinkOption.NOFOLLOW_LINKS)) {
                        if (tempPath.getFileName().endsWith(suffix)){
                            fileList.add(tempPath.toAbsolutePath().toString());
                            System.out.println("add:" + tempPath.toAbsolutePath().toString());
                        }
                    }else if (Files.isDirectory(tempPath, LinkOption.NOFOLLOW_LINKS)) {
                        //如果是目录
                        FileProcessTask fileProcessTask = new FileProcessTask(tempPath.toAbsolutePath().toString(), suffix);
                        fileProcessTask.fork();
                        taskList.add(fileProcessTask);
                    }
                }
                directoryStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
        //进行最后的计算
        addResultFromTask(fileList, taskList);

        return fileList;
    }

    private void addResultFromTask(List<String> fileList, List<FileProcessTask> taskList) {
        for (FileProcessTask processTask : taskList) {
            fileList.addAll(processTask.join());
        }
    }
}
