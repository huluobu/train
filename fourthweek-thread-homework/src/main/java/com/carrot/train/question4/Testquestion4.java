package com.carrot.train.question4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Testquestion4 {
    public static void main(String[] args) {
        Bread b = new Bread();
        ChiefMakeBread cm = new ChiefMakeBread(b);
        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            es.submit(cm);
        }
        es.shutdown();
    }
}
