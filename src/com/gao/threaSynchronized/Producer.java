package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-5
 * Time: 下午8:09
 */
public class Producer implements Runnable {

    private DateStorage storage;

    public Producer(DateStorage storage) {
        this.storage = storage;
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
            storage.set();
        }
    }
}
