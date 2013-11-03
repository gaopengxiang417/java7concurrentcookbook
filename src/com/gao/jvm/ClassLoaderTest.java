package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-10-31
 * Time: 下午10:10
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        System.out.println(new ClassLoaderTest().getClass().getClassLoader());

        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent());
        System.out.println(new ClassLoaderTest().getClass().getClassLoader().getParent().getParent());

        System.out.println();
    }
}
