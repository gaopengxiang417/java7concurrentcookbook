package com.gao.juc;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * User: wangchen.gpx
 * Date: 13-4-9
 * Time: 下午5:03
 * 在该类中，无法访问protected和private的字段
 */
public class AtomIntegerFiledUpdaterTest {
    public class UpdaterDemo{
        public volatile int first = 1;
        volatile int second = 2;
        protected volatile int third = 3;
        private volatile int fouth = 4;
    }

    public AtomicIntegerFieldUpdater<UpdaterDemo> getFildUpdater(String name) {
        return AtomicIntegerFieldUpdater.newUpdater(UpdaterDemo.class, name);
    }

    public void dowork(){
        UpdaterDemo updaterDemo = new UpdaterDemo();
        System.out.println("before update first value : "+getFildUpdater("first").compareAndSet(updaterDemo , 1 , 3));
        System.out.println("after update first value : "+ getFildUpdater("first").get(updaterDemo));

        System.out.println("before update second value : "+getFildUpdater("second").get(updaterDemo));
        System.out.println("after update second value : "+getFildUpdater("second").incrementAndGet(updaterDemo));

        System.out.println("third update : "+getFildUpdater("third").getAndSet(updaterDemo, 99));

        System.out.println("fourth update : "+getFildUpdater("fouth").decrementAndGet(updaterDemo));

    }

    public static void main(String[] args) {
        AtomIntegerFiledUpdaterTest atomIntegerFiledUpdaterTest = new AtomIntegerFiledUpdaterTest();
        atomIntegerFiledUpdaterTest.dowork();
    }
}
