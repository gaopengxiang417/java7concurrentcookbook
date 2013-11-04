package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午9:53
 */
public class SynchronedAccountTest {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        account.setBalance(10000);

        Thread bank = new Thread(new Bank(account));
        Thread company = new Thread(new Company(account));

        System.out.printf("init balance is %9.2f\n" , account.getBalance());

        bank.start();
        company.start();


        bank.join();
        company.join();

        System.out.printf("finally balance is %9.2f" , account.getBalance());
    }
}
