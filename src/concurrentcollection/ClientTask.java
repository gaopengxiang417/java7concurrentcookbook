package concurrentcollection;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

/**
 * User: wangchen.gpx
 * Date: 13-12-4
 * Time: 下午10:43
 * 主要是添加了LinkedBlockedDeque的双向队列，这个队列是一个柱塞队列，里面是通过lock和condition来实现的
 */
public class ClientTask implements Runnable {
    private LinkedBlockingDeque<String> linkedBlockingDeque;

    public ClientTask(LinkedBlockingDeque<String> linkedBlockingDeque) {
        this.linkedBlockingDeque = linkedBlockingDeque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(i).append(":").append(j);
                try {
                    linkedBlockingDeque.put(stringBuffer.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //休眠两秒
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " completed...");
    }
}
