package com.gao.concurrentcollection;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午10:11
 */
public class Company implements Runnable {

    /**
     * 账户信息
     */
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(100L);
            System.out.println("company balance is " + this.account.getBalance());
        }
    }
}
