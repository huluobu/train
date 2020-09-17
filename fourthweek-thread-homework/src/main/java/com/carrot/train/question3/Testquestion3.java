package com.carrot.train.question3;

public class Testquestion3 {
    public static void main(String[] args) {
//        Dumpling dumpling = new Dumpling();
//        EatDumplings eatDumplings1 = new EatDumplings(dumpling);
//        EatDumplings eatDumplings2 = new EatDumplings(dumpling);
//        Thread th1=new Thread(eatDumplings1,"甲");
//        Thread th2=new Thread(eatDumplings2,"乙");
//        th1.start();
//        th2.start();

        Dumpling2 dumpling = new Dumpling2();
        EatDumplings2 eatDumplings1 = new EatDumplings2(dumpling);
        EatDumplings2 eatDumplings2 = new EatDumplings2(dumpling);
        Thread th1=new Thread(eatDumplings1,"甲");
        Thread th2=new Thread(eatDumplings2,"乙");
        th1.start();
        th2.start();
    }
}
