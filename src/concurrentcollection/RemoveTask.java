package concurrentcollection;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * User: wangchen.gpx
 * Date: 13-12-2
 * Time: 下午10:57
 */
public class RemoveTask implements Runnable {

    private ConcurrentLinkedDeque<String> linkedDeque;

    public RemoveTask(ConcurrentLinkedDeque<String> linkedDeque) {
        this.linkedDeque = linkedDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            linkedDeque.pollFirst();
            linkedDeque.pollLast();
        }
    }
}
