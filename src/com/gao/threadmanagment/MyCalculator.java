package com.gao.threadmanagment;

/**
 * User: wangchen.gpx
 * Date: 13-9-30
 * Time: 上午10:43
 * <p><hr>
 *     <blockquote>
 *         <pre>
 *             打印九九乘法表
 *         </pre>
 *     </blockquote>
 * </hr>
 * <hr></hr>
 */
public class MyCalculator {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Calculator(i));
            threads[i] = thread;
        }

        for (Thread thread : threads) {
            thread.start();
            Thread.sleep(1000);
        }
    }


}
class Calculator implements Runnable{
    private int number;

    Calculator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= number; i++) {
            System.out.printf("%d * %d = %d,",i , number , i * number);
        }
        System.out.println();
    }
}