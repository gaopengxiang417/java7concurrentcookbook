package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-12-18
 * Time: 上午11:36
 */
public class ExceptionTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void test() {
        throw new RuntimeException("ctest runing test");
    }
}
