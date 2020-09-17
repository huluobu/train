package com.carrot.train.question3;

public class EatDumplings  implements Runnable{
    private Dumpling dumpling;
    private int size=0;

    public  EatDumplings(Dumpling dumpling) {
        this.dumpling = dumpling;
    }

    public void run() {
        synchronized (this) {
            while (true) {
                if (dumpling.getDumpling_num()<=0) {
                    System.out.println("饺子已经吃完");
                    break;
                }
//                if (!dumpling.isChopsticks()) {
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                } else {
                    dumpling.setChopsticks(false);
                    size++;
                    System.out.println(Thread.currentThread().getName()+"吃的饺子为："+dumpling.getDumpling_num()+"-->已吃了饺子:"+size);
                    dumpling.setDumpling_num(dumpling.getDumpling_num()-1);
                    dumpling.setChopsticks(true);
//                    this.notify();
//                }
            }
        }
    }
}
