package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午9:49
 */
public class Bank implements Runnable {

    private Account account;

    public Bank(Account account) {
        this.account = account;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                account.addAmount(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
