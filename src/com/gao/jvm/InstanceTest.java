package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-9-29
 * Time: 下午1:37
 */
public class InstanceTest {
    private int i = 1;
    private int j;

    {
        j = 2;
    }

    public InstanceTest() {
        i = 3;
        j = 4;
    }

}
