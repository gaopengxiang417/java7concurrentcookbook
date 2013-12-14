package com.gao.concurrentcollection;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午10:16
 */
public class AtomicLongMain {
    public static void main(String[] args) {
        Account account = new Account();

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("start balance is %d \n" , account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("end balance is %d \n" , account.getBalance());
    }
}
