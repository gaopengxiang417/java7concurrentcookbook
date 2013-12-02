package concurrentcollection;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * User: wangchen.gpx
 * Date: 13-12-2
 * Time: 下午10:52
 */
public class AddTask implements Runnable{

    private ConcurrentLinkedDeque<String> listDeque;

    public AddTask(ConcurrentLinkedDeque<String> listDeque) {
        this.listDeque = listDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            String name = Thread.currentThread().getName();
            listDeque.add(name + " " + i);
        }
    }
}
