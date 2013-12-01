package com.gao.forkjoin;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午9:54
 */
public class Product {
    private String name;

    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
