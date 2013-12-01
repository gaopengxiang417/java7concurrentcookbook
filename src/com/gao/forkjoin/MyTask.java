package com.gao.forkjoin;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * User: wangchen.gpx
 * Date: 13-12-1
 * Time: 上午9:57
 */
public class MyTask extends RecursiveAction {

    private static final long serialVersionUID = -8220807072259601675L;
    //第一个
    private int first;

    //最后一个
    private int last;

    //新增的值
    private double increment;

    private List<Product> list;

    public MyTask(int first, int last, double increment, List<Product> list) {
        this.first = first;
        this.last = last;
        this.increment = increment;
        this.list = list;
    }

    @Override
    protected void compute() {
        if (last - first <= 10) {
            changePrice();
        }else{
            int middle = (last + first) / 2;

            MyTask preTask = new MyTask(first, middle, increment, list);
            MyTask lastTask = new MyTask(middle + 1, last, increment, list);

            invokeAll(preTask, lastTask);
        }
    }

    private void changePrice() {
        for (int i = first; i < last; i++) {
            Product product = list.get(i);
            product.setPrice(product.getPrice() * (increment + 1));
        }
    }
}
