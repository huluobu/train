package com.carrot.train.thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class Test01Test {

    @Test
    public void run() {
        Test01 test01 = new Test01();
//        test01.run();
        test01.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("test线程："+i);
        }
    }
}