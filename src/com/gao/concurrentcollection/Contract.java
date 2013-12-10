package com.gao.concurrentcollection;

/**
 * User: wangchen.gpx
 * Date: 13-12-8
 * Time: 下午4:27
 */
public class Contract {

    private String name;

    private String phone;

    public Contract(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
