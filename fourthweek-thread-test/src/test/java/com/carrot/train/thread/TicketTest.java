package com.carrot.train.thread;

import org.junit.Test;

import static org.junit.Assert.*;

public class TicketTest {

    @Test
    public void run() {
        Ticket ticket = new Ticket();
        TicketWin tw1 = new TicketWin(ticket, "窗口1");
        TicketWin tw2 = new TicketWin(ticket, "窗口2");
        TicketWin tw3 = new TicketWin(ticket, "窗口3");
        TicketWin tw4 = new TicketWin(ticket, "窗口4");
        tw1.start();
        tw2.start();
        tw3.start();
        tw4.start();
    }
}