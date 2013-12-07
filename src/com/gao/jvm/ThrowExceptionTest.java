package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-11-26
 * Time: 下午3:38
 */
public class ThrowExceptionTest {
    public static void main(String[] args) {
        try {
            g();
        } catch (Throwable throwable) {

        }
    }

    static void f() {
        try {
//            throw new Throwable();
        } catch (Exception e) {
            System.out.println("f method exception");
            e.printStackTrace();
        }
    }


    static void g() {
        try {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.out.println("g method exception");
                throw e.fillInStackTrace();
            }
        } catch (Exception e) {
            System.out.println("g finally exception");
            e.printStackTrace();
        } catch (Throwable throwable) {
            System.out.println("throwable");
        }
    }
}
