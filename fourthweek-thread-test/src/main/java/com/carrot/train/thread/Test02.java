package com.carrot.train.thread;

public class Test02 {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        AddMonkey addMonkey = new AddMonkey(bankCard);
        TakeMonkey takeMonkey = new TakeMonkey(bankCard);
        Thread th1 = new Thread(addMonkey, "tom--");
        Thread th2 = new Thread(takeMonkey, "levis--");
        th1.start();
        th2.start();

    }
}
