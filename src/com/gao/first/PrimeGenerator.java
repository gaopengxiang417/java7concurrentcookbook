package com.gao.first;

/**
 * User: wangchen.gpx
 * Date: 13-3-20
 * Time: 上午9:01
 */
public class PrimeGenerator implements Runnable {
    @Override
    public void run() {
        Long number = 1L;
        while (true) {
            if (isPrime(number)) {
                System.out.println("number "+number +" is a prime");
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("the prime generator is interrupted");
                return;
            }
            number++;
        }
    }

    private boolean isPrime(Long number) {
        if (number <= 2) {
            return true;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
