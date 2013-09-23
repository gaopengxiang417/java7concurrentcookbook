package com.gao.jvm;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * User: wangchen.gpx
 * Date: 13-9-23
 * Time: 上午10:48
 */
public class ClassCastTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> aClass = Long.class;

        Constructor<?> constructor = aClass.getConstructor(String.class);
        Object o = constructor.newInstance("121212");
        System.out.println(o);
        System.out.println(o.getClass());
    }
}
