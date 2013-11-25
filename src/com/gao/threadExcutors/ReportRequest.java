package com.gao.threadExcutors;

import java.util.concurrent.CompletionService;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:28
 */
public class ReportRequest implements Runnable {
    private String name;

    private CompletionService<String> service;

    public ReportRequest(String name, CompletionService<String> service) {
        this.name = name;
        this.service = service;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            ReportGenerator reportGenerator = new ReportGenerator(name + i, "title" + i);
            service.submit(reportGenerator);
        }
    }
}
