package com.gao.jvm;

import java.util.ArrayList;

/**
 * User: wangchen.gpx
 * Date: 13-3-30
 * Time: 下午8:34
 */
public class PerformanceTest {
    private static Long per = 1024L * 1024;
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            persons.add(new Person("first" , "second"));
        }

        Runtime runtime = Runtime.getRuntime();

        runtime.gc();

        long used = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("userd memery:"+getM(used));
        System.out.println("total memery:"+getM(runtime.totalMemory()));
    }

    public static Long getM(Long result) {
        return result / per;
    }
    public static class Person{
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
