package com.gao.threadmanagment;

/**
 * User: wangchen.gpx
 * Date: 13-10-14
 * Time: 下午7:59
 * <hr>
 *     主要说明了获取线程的ID，name，priority等信息
 * </hr>
 * <hr></hr>
 */
public class CalculatorInformation {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        Thread.State[] states = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new CalculatorInfo(i));
            //设置不同的优先级
            if (i % 2 == 0){
                thread.setPriority(Thread.MAX_PRIORITY);
            }else{
                thread.setPriority(Thread.MIN_PRIORITY);
            }
            threads[i] = thread;
            states[i] = threads[i].getState();
        }

        //打印现在的状态
        for (int i = 0; i < 10; i++) {
            System.out.println("current status :" + states[i]);
        }


        //启动线程
        for (int i = 0; i < 10; i++) {
            threads[i].start();
        }

        //监视状态
        boolean finished = false;
        while (!finished) {
            for (int i = 0; i < 10; i++) {
                if (threads[i].getState() != states[i]){
                    states[i] = threads[i].getState();
                    System.out.printf("main:id %d,name %s",threads[i].getId(),threads[i].getName());
                    System.out.printf(",priority:%d" , threads[i].getPriority());
                    System.out.printf(",old status:",states[i]);
                    System.out.printf(",new status:",threads[i].getState());
                }
            }

            finished = true;
            for (int i = 0; i < 10; i++) {
                finished = finished && (threads[i].getState() == Thread.State.TERMINATED);
            }
        }
    }
}

class CalculatorInfo implements Runnable{
    private int number;

    CalculatorInfo(int number) {
        this.number = number;
    }


    @Override
    public void run() {
        System.out.printf("%s,",Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            System.out.printf("%d * %d = %d,", number , i , number * i);
        }
        System.out.println();
    }
}
