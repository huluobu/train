package com.carrot.train.thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class Thread02Test {

    @Test
    public void run() {
        Thread02 thread02 = new Thread02();
        Thread thread = new Thread(thread02);
        thread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("thread02test 执行次数："+i);
        }
    }
}