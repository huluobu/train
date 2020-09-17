package com.carrot.train.question2;

public class Testquestion2 {
    public static void main(String[] args) {
        SaveData2 sa = new SaveData2();
        Runnable target;
        Thread th1 = new Thread(sa,"线程1");
        Thread th2 = new Thread(sa,"线程2");
        th1.start();
        th2.start();
    }
}
