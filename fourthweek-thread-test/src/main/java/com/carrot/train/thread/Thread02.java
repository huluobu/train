package com.carrot.train.thread;

public class Thread02 implements Runnable {
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread02 执行次数："+i);
        }
    }
}
