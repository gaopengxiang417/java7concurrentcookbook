package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-3-30
 * Time: 下午8:49
 */
public class SynchronizedTest {
    private MyField myField;

    public synchronized MyField getMyField() {
        if (myField == null) {
            myField = new MyField();
        }
        return myField;
    }
}
