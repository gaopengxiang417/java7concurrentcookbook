package com.gao.threadmanagment;

/**
 * User: wangchen.gpx
 * Date: 13-11-3
 * Time: 下午1:19
 * 线程里面的uncaughtException 主要是通过注册Exceptionhandler可以进行自定义的实现
 */
public class ExcetionThreadTest {
    public static void main(String[] args) {
        Thread thread = new Thread(new TaskTest());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());

        thread.start();
    }
}

class TaskTest implements Runnable{
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
        int ttt = Integer.parseInt("TTT");
    }
}

class ExceptionHandler implements Thread.UncaughtExceptionHandler {
    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     *
     * @param t the thread
     * @param e the exception
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("an exception has been caughted..\n");
        System.out.printf("thread : %d\n", t.getId());
        System.out.printf("Exception : %s : %s\n" , e.getClass().getName() , e.getMessage());
        System.out.printf("stack trace : \n");
        e.printStackTrace(System.out);
        System.out.printf("thread status : %s\n", t.getState().name());
    }
}
