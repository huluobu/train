package com.carrot.train.question2;

import java.util.ArrayList;

public class Testquestion2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        SaveData2 sa1 = new SaveData2(arrayList);
        SaveData2 sa2 = new SaveData2(arrayList);
        Thread th1 = new Thread(sa1,"线程1");
        Thread th2 = new Thread(sa2,"线程2");
        th1.start();
        th2.start();
    }
}
