package com.gao.threadExcutors;

/**
 * User: wangchen.gpx
 * Date: 13-11-24
 * Time: 下午1:02
 */
public class Result {
    private String name;

    private int value;

    public Result(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
