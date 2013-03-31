package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-3-30
 * Time: 下午8:51
 */
public class DoubleCheckTest {
    private volatile MyField myField;

    public MyField getMyField() {
        if (myField == null) {
            synchronized (this) {
                if (myField == null) {
                    myField = new MyField();
                }
            }
        }
        return myField;
    }
}
