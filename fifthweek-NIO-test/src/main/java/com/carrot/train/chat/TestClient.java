package com.carrot.train.chat;

import java.io.IOException;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) throws IOException {
        final ChatClient chatClient = new ChatClient();
        new Thread() {
            @Override
            public void run()  {
                try {
                    chatClient.receiveMsg();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            String msg = sc.nextLine();
            chatClient.sendMsg(msg);
        }
    }
}
