package com.gao.threadExcutors;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午4:13
 */
public class FutureWrap extends FutureTask<String> {
    private String name;
    public FutureWrap(Callable callable) {
        super(callable);
        this.name = ((ExecuteTask)callable).getName();
    }

    /**
     * Protected method invoked when this task transitions to state
     * {@code isDone} (whether normally or via cancellation). The
     * default implementation does nothing.  Subclasses may override
     * this method to invoke completion callbacks or perform
     * bookkeeping. Note that you can query status inside the
     * implementation of this method to determine whether this task
     * has been cancelled.
     */
    @Override
    protected void done() {
        if (isCancelled()) {
            System.out.printf("%s is canncaled...\n" , name);
        }else if (isDone()) {
            System.out.printf("%s is doneed....\n" , name);
        }
    }
}
