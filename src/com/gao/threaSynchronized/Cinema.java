package com.gao.threaSynchronized;

/**
 * User: wangchen.gpx
 * Date: 13-11-4
 * Time: 下午10:17
 */
public class Cinema {
    private int office1ticket;
    private int office2ticket;

    private Object office1Object;
    private Object office2Object;

    public Cinema() {
        office1ticket = 20;
        office2ticket = 20;
        office1Object = new Object();
        office2Object = new Object();
    }

    public boolean takeTicket1(int number) {
        synchronized (office1Object) {
            if (number <= office1ticket) {
                office1ticket -= number;
                return true;
            }
            return false;
        }
    }

    public boolean takeTicket2(int number) {
        synchronized (office2Object) {
            if (number <= office2ticket) {
                office2ticket -= number;
                return true;
            }
            return false;
        }
    }

    public void withdraw1(int number) {
        synchronized (office1Object) {
            office1ticket += number;
        }
    }

    public void withdraw2(int number) {
        synchronized (office2Object) {
            office2ticket += number;
        }
    }

    public int getOffice1ticket() {
        return office1ticket;
    }

    public int getOffice2ticket() {
        return office2ticket;
    }
}
