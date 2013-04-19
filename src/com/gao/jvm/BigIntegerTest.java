package com.gao.jvm;

import java.math.BigInteger;

/**
 * User: wangchen.gpx
 * Date: 13-4-19
 * Time: 上午9:14
 */
public class BigIntegerTest {
    public static void main(String[] args) {
        BigInteger fiveThousand = new BigInteger("5000");
                BigInteger fiftyThousand = new BigInteger("50000");
               BigInteger fiveHundredThousand = new BigInteger("500000");
               BigInteger total = BigInteger.ZERO;
               total.add(fiveThousand);
               total.add(fiftyThousand);
               total.add(fiveHundredThousand);
                System.out.println(total);

    }
}
