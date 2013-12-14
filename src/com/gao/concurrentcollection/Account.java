package com.gao.concurrentcollection;

import java.util.concurrent.atomic.AtomicLong;

/**
 * User: wangchen.gpx
 * Date: 13-12-14
 * Time: 上午10:06
 */
public class Account {
    /**
     * 账户余额
     */
    private AtomicLong balance;

    public Account() {
        this.balance = new AtomicLong(1000L);
    }

    public void addAmount(Long amount) {
        this.balance.getAndAdd(amount);
    }

    public void substractAmount(Long amount) {
        this.balance.getAndAdd(-amount);
    }

    public Long getBalance() {
        return balance.get();
    }

    public void setBalance(long balance) {
        this.balance.set(balance);
    }
}
