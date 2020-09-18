package com.carrot.train.question2;

import java.util.ArrayList;

public class SaveData2 implements Runnable {
    private ArrayList<Integer> arrayList;

    public SaveData2(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;

    }


    public void run() {
        int i = 0;
        synchronized (arrayList) {
            while (true) {
                if (arrayList.size() >= 100) {
                    System.out.println("数组长度已满");
                    break;
                } else {
                    arrayList.add(i);
                    System.out.println(Thread.currentThread().getName()+"插入的数据是："+i+"---->数组长度为："+arrayList.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                }


            }
/*
            for (int i = 0; i < 100; i++) {
                arrayList.add(i);
                System.out.println(Thread.currentThread().getName()+"插入的数据是："+i+"---->数组长度为："+arrayList.size());
            }

*/


        }

    }
}
