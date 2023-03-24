package com.calove.multithread.learn.base;

import lombok.extern.slf4j.Slf4j;

/**
 * @author calove
 * 创建现成的第一种方式
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + "打了：" + i + "个小兵");
        }
    }
}
