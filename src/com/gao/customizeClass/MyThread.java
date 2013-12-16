package com.gao.customizeClass;

import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-12-16
 * Time: 下午10:08
 */
public class MyThread extends Thread {
    /**
     * 线程的创建时间
     */
    private Date createTime;

    /**
     * 线程的开始执行时间
     */
    private Date startTime;

    /**
     * 线程的结束时间
     */
    private Date finishTime;

    public MyThread(Runnable target, String name) {
        super(target,name);
        this.createTime = new Date();
    }

    @Override
    public void run() {
        setStartTime();
        super.run();
        setFinishTime();
    }

    public void setStartTime(){
        this.startTime = new Date();
    }

    public void setFinishTime() {
        this.finishTime = new Date();
    }

    public long getExecuteTime(){
        return finishTime.getTime() - startTime.getTime();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("start time :")
                .append(startTime)
                .append(",execute time:")
                .append(getExecuteTime());
        return sb.toString();
    }
}
