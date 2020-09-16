package com.carrot.train.thread;

public class Ticket implements Runnable {
    private Integer ticket=100;
    private Object object=new Object();
    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket<=0) {
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"票");
                System.out.println(Thread.currentThread().getState());

                ticket--;
            }
        }
    }
}
