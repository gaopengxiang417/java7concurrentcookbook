package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-6
 * Time: 下午9:33
 */
public class BlockRunnable implements Runnable {
    private  PrintBlocker printBlocker;

    public BlockRunnable(PrintBlocker printBlocker) {
        this.printBlocker = printBlocker;
    }

    @Override
    public void run() {
        System.out.printf("%s,start to print \n" , Thread.currentThread().getName());
        printBlocker.print();
        System.out.printf("%s,end to print \n" , Thread.currentThread().getName());
    }
}
