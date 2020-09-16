package com.carrot.train.thread;

public class TakeMonkey implements Runnable {
    private BankCard bankCard;

    public TakeMonkey(BankCard bankCard) {
        this.bankCard = bankCard;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.bankCard.take(100);
        }
    }
}
