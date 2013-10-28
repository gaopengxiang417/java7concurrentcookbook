package com.gao.jvm;

import java.util.HashMap;

/**
 * User: wangchen.gpx
 * Date: 13-10-28
 * Time: 下午8:35
 */
public class HashMapCounter {
    public static void main(String[] args) {
        String str = "one two three two three three";
        String[] strings = str.split(" ");
        //first start time
        long start = System.nanoTime();
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            for (String string : strings) {
                if (hashMap.containsKey(string)){
                    Integer integer = hashMap.get(string);
                    hashMap.put(string,integer+1);
                }else{
                    hashMap.put(string , 1);
                }
            }
        }

        System.out.println("first time : " + (System.nanoTime() - start));


        //second start time
        long secondStart = System.nanoTime();
        HashMap<String, MyInteger> myIntegerHashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            for (String string : strings) {
                if (myIntegerHashMap.containsKey(string)) {
                    MyInteger myInteger = myIntegerHashMap.get(string);
                    myInteger.setNumber(myInteger.getNumber() + 1);
                }else{
                    myIntegerHashMap.put(string , new MyInteger(1));
                }
            }
        }
        System.out.println("second time :" + (System.nanoTime() - secondStart));


        //third start time
        long thirdStart = System.nanoTime();
        HashMap<String, MyInteger> thirdHashMap = new HashMap<>();
        for (int i = 0; i < 1000000; i++) {
            for (String string : strings) {
                MyInteger myInteger = new MyInteger(1);
                MyInteger result = thirdHashMap.put(string, myInteger);

                if (result != null) {
                    result.setNumber(result.getNumber() + 1);
                }


            }
        }
        System.out.println("third time :" + (System.nanoTime() - thirdStart));
    }
}

class MyInteger{
    private int number;

    MyInteger(int number) {
        this.number = number;
    }

    int getNumber() {
        return number;
    }

    void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
