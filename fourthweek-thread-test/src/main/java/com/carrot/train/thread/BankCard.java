package com.carrot.train.thread;

public class BankCard {
    private double balance=0.0;
    private boolean flag=false;

    public synchronized void save(double m) {
        if (flag) {
            try {
                this.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance + m;
        System.out.println(Thread.currentThread().getName()+"save monkey is :"+m+"--balance is:"+balance);
        flag=true;
        this.notify();
    }

    public synchronized void take(double m) {
        if (!false) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance = balance - m;
        System.out.println(Thread.currentThread().getName()+"take monkey is :"+m+"--balance is:"+balance);
        flag = false;
        this.notify();
    }
}
