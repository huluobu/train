package com.carrot.train.question3;

public class Dumpling2 {
    private int dumpling_num = 20;
    private boolean chopsticks=true;

    public synchronized void eat() {
//        得到筷子开始吃饺子，
        if (chopsticks) {

            chopsticks = false;
            System.out.println(Thread.currentThread().getName()+"吃的饺子编号为："+dumpling_num);
            dumpling_num--;
            chopsticks = true;
            this.notify();
        }
//        没有得到筷子，等待
        if (!chopsticks) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public int getDumpling_num() {
        return dumpling_num;
    }

    public void setDumpling_num(int dumpling_num) {
        this.dumpling_num = dumpling_num;
    }

    public boolean isChopsticks() {
        return chopsticks;
    }

    public void setChopsticks(boolean chopsticks) {
        this.chopsticks = chopsticks;
    }
}
