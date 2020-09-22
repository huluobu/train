package com.carrot.train.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ChatClient {
    private final String HOST = "127.0.0.1";
    private int PORT = 9999;
    private SocketChannel socketChannel;
    private String userName;

    public ChatClient() throws IOException {
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress address = new InetSocketAddress(HOST, PORT);
        if (!socketChannel.connect(address)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("连接服务器可以做其他事情");
            }
        }
        userName = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println("client(" + userName + ") is ready");

    }

    public void sendMsg(String msg) throws IOException {
        if (msg.equalsIgnoreCase("exit")) {
            socketChannel.close();
            return;
        }
        msg = userName + "say is :" + msg;
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        socketChannel.write(buffer);
    }

    public void receiveMsg() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int size=socketChannel.read(buffer);
        if (size > 0) {
            String msg = new String(buffer.array());
            System.out.println(msg.trim());
        }
    }
}
