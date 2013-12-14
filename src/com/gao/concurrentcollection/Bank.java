package com.gao.concurrentcollection;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午10:12
 */
public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.account.substractAmount(100L);
            System.out.println("current bank balance is " + this.account.getBalance());
        }
    }
}
