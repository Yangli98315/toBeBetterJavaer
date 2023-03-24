package com.calove.multithread.learn.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyRunnableTest {

    @Test
    public void run() {
        Thread fidoit = new Thread(new MyRunnable());
        fidoit.setName("fidoit");
        Thread calove = new Thread(new MyRunnable());
        calove.setName("calove");
        Thread mylove = new Thread(new MyRunnable());
        mylove.setName("mylove");
        fidoit.start();
        calove.start();
        mylove.start();
    }
}