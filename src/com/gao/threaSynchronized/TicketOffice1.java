package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午10:22
 */
public class TicketOffice1 implements Runnable {

    private Cinema cinema;

    public TicketOffice1(Cinema cinema) {
        this.cinema = cinema;
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
        cinema.takeTicket1(2);
        cinema.takeTicket2(4);
        cinema.withdraw1(1);
        cinema.withdraw1(2);
        cinema.withdraw2(6);
        cinema.takeTicket2(5);
    }
}
