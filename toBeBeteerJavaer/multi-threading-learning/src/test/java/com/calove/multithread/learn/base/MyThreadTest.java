package com.calove.multithread.learn.base;

public class MyThreadTest {

    @org.junit.Test
    public void run() {
        MyThread calove = new MyThread();
        calove.setName("calove");
        MyThread fidoit = new MyThread();
        fidoit.setName("fidoit");
        MyThread mylove = new MyThread();
        mylove.setName("mylove");
        calove.start();
        fidoit.start();
        mylove.start();
    }
}