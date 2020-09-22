package com.carrot.train.question3;

import java.util.LinkedList;
import java.util.Queue;

public class EatDumplings2 implements Runnable {
    private static Dumpling2 dumpling;
    private Queue<Integer> queue = new LinkedList<Integer>();

    public  EatDumplings2(Dumpling2 dumpling) {
        this.dumpling = dumpling;
    }
    public  void run() {
        while (true) {
            if (dumpling.getDumpling_num() <= 0) {
                System.out.println("饺子已经吃完");
                break;
            }else{
                eatmethod();
            }


        }
    }
    public synchronized void eatmethod(){
        if(dumpling.getDumpling_num()>=1){
            dumpling.eat();
            queue.add(dumpling.getDumpling_num()+1);

            System.out.println(Thread.currentThread().getName()+"-->已吃了饺子数量为:"+queue.size()+"\n"+
                    "已吃饺子序列为："+queue.toString());

        }


    }

}
