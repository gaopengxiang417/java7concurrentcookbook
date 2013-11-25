package com.gao.threadExcutors;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:30
 */
public class ReportRecivier implements Runnable {
    private CompletionService<String> service;

    private boolean isDone;
    public ReportRecivier(CompletionService<String> service) {
        this.service = service;
        isDone = false;
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
        while (!isDone) {
            Future<String> future = null;
            try {
                future = service.take();
                if (future != null) {
                    String s = future.get();
                    System.out.println("recivicr:" + s);
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("report end....");
    }


    public void setDone(boolean done) {
        isDone = done;
    }
}
