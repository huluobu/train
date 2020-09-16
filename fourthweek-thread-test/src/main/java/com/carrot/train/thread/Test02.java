package com.carrot.train.thread;

public class Test02 {
    public static void main(String[] args) {
        BankCard bankCard = new BankCard();
        AddMonkey addMonkey = new AddMonkey(bankCard);
        TakeMonkey takeMonkey = new TakeMonkey(bankCard);
        Thread th1 = new Thread(addMonkey, "tom--");
        Thread th2 = new Thread(takeMonkey, "levis--");
        Thread th3 = new Thread(addMonkey, "angular");
        Thread th4 = new Thread(takeMonkey, "george");
        th1.start();
        th2.start();
        th3.start();
        th4.start();

    }
}
