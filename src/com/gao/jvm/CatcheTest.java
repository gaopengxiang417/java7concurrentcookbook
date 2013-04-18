package com.gao.jvm;

/**
 * User: wangchen.gpx
 * Date: 13-4-18
 * Time: 上午9:23
 */
public class CatcheTest {
    static {
               initializeIfNecessary();
            }
       private static int sum ;
       public static int getSum() {
                initializeIfNecessary();
                return sum;
            }
        private static boolean initialized = false;
        private static synchronized void initializeIfNecessary() {
               if (!initialized) {
                       for (int i = 0; i < 100; i++)
                                sum += i;
                        initialized = true;
                    }
          }

    public static void main(String[] args) {
        System.out.println(CatcheTest.getSum());
        CatcheTest x = new CatcheTest();
        System.out.println(x.getSum());
    }

}
