package com.carrot.train.thread;

public class Ticket implements Runnable {
    private Integer ticket=100;
    public void run() {
        while (true) {
            synchronized (ticket) {
                if (ticket<=0) {
                    System.out.println("票已经卖完了");
                    break;
                }
                System.out.println(Thread.currentThread().getName()+"卖了第"+ticket+"票");
                ticket--;
            }


        }
    }
}
