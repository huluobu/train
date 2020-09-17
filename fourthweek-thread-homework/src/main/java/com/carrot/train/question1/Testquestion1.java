package com.carrot.train.question1;

public class Testquestion1 {
    public static void main(String[] args) {
        SaveData sa = new SaveData();
        Runnable target;
        Thread th1 = new Thread(sa,"线程1");
        Thread th2 = new Thread(sa,"线程3");
        th1.start();
        th2.start();
    }
}
