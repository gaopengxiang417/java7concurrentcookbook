package com.gao.threadSyncronizedUtils;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 下午12:01
 */
public class Result {
    private int[] data;

    public Result(int length) {
        this.data = new int[length];
    }

    public void setData(int index, int value) {
        data[index] = value;
    }

    public int[] getData(){
        return data;
    }
}
