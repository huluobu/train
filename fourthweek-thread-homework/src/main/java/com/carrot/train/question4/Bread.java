package com.carrot.train.question4;

import java.util.concurrent.ArrayBlockingQueue;

public class Bread  {
    private BreadComponent bc = new BreadComponent();
    private ArrayBlockingQueue<Integer> clips = new ArrayBlockingQueue<Integer>(3);

    public boolean makeBread() {
        boolean flag = false;
        //放面包
        if (clips.offer(1)) {
            System.out.println(Thread.currentThread().getName()+"使用夹子"+clips.size());
            bc.usea();
            clips.poll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //放生菜
        if (clips.offer(1)) {
            System.out.println(Thread.currentThread().getName()+"使用夹子"+clips.size());
            bc.useb();
            clips.poll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //放肉
        if (clips.offer(1)) {
            System.out.println(Thread.currentThread().getName()+"使用夹子"+clips.size());
            bc.usec();
            clips.poll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //放面包
        if (clips.offer(1)) {
            System.out.println(Thread.currentThread().getName()+"使用夹子"+clips.size());
            bc.usea();
            clips.poll();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        flag = true;
        return flag;
    }
}
