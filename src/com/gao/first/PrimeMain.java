package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-20
 * Time: 上午9:05
 */
public class PrimeMain {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        Thread thread = new Thread(primeGenerator);
        thread.start();

        try {
            Thread.sleep(1000);
            System.out.println("sleep.......... closly");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("out of try");
        thread.interrupt();
    }
}
