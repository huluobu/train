package com.carrot.train.thread;

/**
 * @Author carrot
 * @Description 
 * @Date 2020/9/16 10:07
 **/
public class Test01 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("test01执行次数" + i);
        }
    }
    

}
