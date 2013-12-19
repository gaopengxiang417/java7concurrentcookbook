package com.gao.customizeClass;

import java.util.Date;

/**
 * User: wangchen.gpx
 * Date: 13-12-19
 * Time: 下午9:37
 */
public class MyExecuteThread extends Thread {
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    public MyExecuteThread(Runnable target, String name) {
        super(target, name);
        this.createTime = new Date();
    }

    @Override
    public void run() {
        startTime = new Date();
        super.run();
        endTime = new Date();
    }

    public long getExecuteTime(){
        return endTime.getTime() - startTime.getTime();
    }

    @Override
    public String toString() {
        return "name=" + super.getName() +
                "execute time = " + getExecuteTime();
    }
}
