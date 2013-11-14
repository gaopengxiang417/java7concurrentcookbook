package com.gao.jvm;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * User: wangchen.gpx
 * Date: 13-11-12
 * Time: 上午11:33
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        double dd = 2323.2323231212;
        System.out.println(new BigDecimal(dd));
        System.out.println(new BigDecimal(dd).setScale(4 , RoundingMode.HALF_EVEN));
    }
}
