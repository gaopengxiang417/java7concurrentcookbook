package com.gao.threadExcutors;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * User: wangchen.gpx
 * Date: 13-11-25
 * Time: 下午10:51
 */
public class RejectTaskController implements RejectedExecutionHandler {
    /**
     * Method that may be invoked by a {@link java.util.concurrent.ThreadPoolExecutor} when
     * {@link java.util.concurrent.ThreadPoolExecutor#execute execute} cannot accept a
     * task.  This may occur when no more threads or queue slots are
     * available because their bounds would be exceeded, or upon
     * shutdown of the Executor.
     * <p/>
     * <p>In the absence of other alternatives, the method may throw
     * an unchecked {@link java.util.concurrent.RejectedExecutionException}, which will be
     * propagated to the caller of {@code execute}.
     *
     * @param r        the runnable task requested to be executed
     * @param executor the executor attempting to execute this task
     * @throws java.util.concurrent.RejectedExecutionException
     *          if there is no remedy
     */
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.printf("RejectTaskController: has reject %s\n" , r.toString());
        System.out.printf("RejectTaskController: executor:%s\n" , executor.toString());
        System.out.printf("RejectTaskController: isTerminizing:%s\n" , executor.isTerminating());
        System.out.printf("RejectTaskController: isTerminized:%s\n" , executor.isTerminated());
    }
}
