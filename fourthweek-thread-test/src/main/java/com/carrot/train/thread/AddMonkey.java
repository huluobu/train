package com.carrot.train.thread;

public class AddMonkey implements Runnable {
    private BankCard bankCard;

    public AddMonkey(BankCard bankCard) {
        this.bankCard = bankCard;
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            this.bankCard.save(100);
        }

    }
}
