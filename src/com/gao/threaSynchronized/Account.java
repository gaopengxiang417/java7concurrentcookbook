package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午9:49
 */
public class Account {
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public  void addAmount(double amout) throws InterruptedException {
        Thread.sleep(1000);

        balance += amout;
        System.out.println("add " + balance);
    }

    public  void substractAmount(double amount) throws InterruptedException {

        Thread.sleep(1000);

        balance -= amount;
        System.out.println("substract " + balance);
    }
}
