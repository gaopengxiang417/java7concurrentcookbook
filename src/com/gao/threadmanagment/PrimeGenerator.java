package com.gao.threadmanagment;

/**
 * User: wangchen.gpx
 * Date: 13-10-20
 * Time: 上午9:15
 */
public class PrimeGenerator{

    public static void main(String[] args) {
        PrimeGeneratorThread primeGenerator = new PrimeGeneratorThread();
        primeGenerator.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        primeGenerator.interrupt();
    }
}
class PrimeGeneratorThread extends Thread{
    @Override
    public void run() {
        int number = 1;
        while (true) {
            if (isPrime(number)){
                System.out.printf("the prime number is %d\n" , number);
            }

            if (isInterrupted()) {
                System.out.println("the prime generator is interrupted");
                return;
            }
            number++;
        }
    }

    public boolean isPrime(int number) {
        if (number <= 2)
            return true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}