package com.calove.multithread.learn.base;

/**
 * @author calove
 * 创建现成的另一种方式
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "打了：" + i + "个小兵");
        }
    }
}
