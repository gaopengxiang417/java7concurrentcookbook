package com.gao.forkjoin;

import java.util.ArrayList;
import java.util.List;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午9:55
 */
public class ProductGenerator {

    private int size;

    public ProductGenerator(int size) {
        this.size = size;
    }

    public List<Product> generateProduct() {
        List<Product> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Product product = new Product("product" + i, 20);
            list.add(product);
        }
        return list;
    }
}
