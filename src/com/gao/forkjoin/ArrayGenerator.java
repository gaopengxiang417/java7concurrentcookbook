package com.gao.forkjoin;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 下午2:20
 */
public class ArrayGenerator {

    public   int[] generate(int size) {
        Random random = new Random();

        int[] ints = new int[size];

        for (int i = 0; i < size; i++) {
            ints[i] = random.nextInt(10);
        }

        return ints;
    }
}
