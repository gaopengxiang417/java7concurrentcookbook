package concurrentcollection;

import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * User: wangchen.gpx
 * Date: 13-12-2
 * Time: 下午10:59
 */
public class ConcurrentLinkedDequeMain {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedDeque<String> linkedDeque = new ConcurrentLinkedDeque<>();

        Thread[] addThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            AddTask addTask = new AddTask(linkedDeque);
            Thread thread = new Thread(addTask);
            addThreads[i] = thread;
            thread.start();
        }

        System.out.println("start to add task...........");
        for (Thread addThread : addThreads) {
            addThread.join();
        }

        System.out.println("totalsize:" + linkedDeque.size());

        Thread[] pollThreads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            RemoveTask removeTask = new RemoveTask(linkedDeque);
            Thread thread = new Thread(removeTask);
            pollThreads[i] = thread;
            thread.start();
        }

        System.out.println("start to remove task.........");
        for (Thread pollThread : pollThreads) {
            System.out.println("totalsize:" + linkedDeque.size());
            pollThread.join();
        }

        System.out.println("totalsize:" + linkedDeque.size());

    }
}
