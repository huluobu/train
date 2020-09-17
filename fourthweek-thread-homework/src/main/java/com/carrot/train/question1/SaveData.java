package com.carrot.train.question1;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SaveData implements Runnable {
    private ArrayList<Integer> arrayList=new ArrayList<Integer>();


    public void run() {
        int i = 0;
        while (true) {
            if (arrayList.size() >= 100) {
                System.out.println("数组长度已满");
                break;
            }
            arrayList.add(i);
            System.out.println(Thread.currentThread().getName()+"插入的数据是："+i+"---->数组长度为："+arrayList.size());
            i++;

        }

    }
}
