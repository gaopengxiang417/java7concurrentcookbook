package com.gao.threadSyncronizedUtils;

import java.util.Random;

/**
 * User: wangchen.gpx
 * Date: 13-11-16
 * Time: 上午11:56
 */
public class MatrixMock {
    private int[][] data;

    public MatrixMock(int rows, int columns, int number) {
        data = new int[rows][columns];

        int counter = 0;
        Random random = new Random();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int ij = random.nextInt(10);
                data[i][j] = ij;
                if (ij == number) {
                    counter++;
                }
            }
        }

        System.out.printf("there are finally %d number %d\n" , counter , number);
    }

    public int[] getRow(int row){
        if (row >0 && row < data.length){
            return data[row];
        }
        return null;
    }

}
