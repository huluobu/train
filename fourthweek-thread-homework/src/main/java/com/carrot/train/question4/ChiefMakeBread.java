package com.carrot.train.question4;


public class ChiefMakeBread implements Runnable {
    private Bread bread=new Bread();
    private int index = 0;
    public ChiefMakeBread(Bread bread) {
        this.bread=bread;
    }
    public void run() {
        while (true) {
            if (index>=20) {
                System.out.println("20个面包已经制作完成");
                break;
            }else {
                bread.makeBread();
                index++;
                System.out.println(Thread.currentThread().getName() + "制作汉堡是：" + (index-1));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
