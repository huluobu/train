package com.carrot.train.thread;

public class TicketWin extends Thread {
    public TicketWin(Runnable runnable,String name) {
        super(runnable,name);
    }
}
