package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午10:25
 */
public class SynchronizedBlockTest {
    public static void main(String[] args) throws InterruptedException {
        Cinema cinema = new Cinema();

        Thread office1 = new Thread(new TicketOffice1(cinema));
        Thread office2 = new Thread(new TicketOffice2(cinema));

        office1.start();
        office2.start();

        office1.join();
        office2.join();

        System.out.println(cinema.getOffice1ticket());
        System.out.println(cinema.getOffice2ticket());

    }
}
