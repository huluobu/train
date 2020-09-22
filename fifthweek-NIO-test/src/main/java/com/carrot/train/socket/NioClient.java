package com.carrot.train.socket;


import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.configureBlocking(false);
            InetSocketAddress address = new InetSocketAddress("127.0.0.1", 9999);
            if (!sc.connect(address)) {
                while (!sc.finishConnect()) {
                    System.out.println("can do other things");

                }
            }

            String msg = "hello server";
            ByteBuffer writebuf = ByteBuffer.wrap(msg.getBytes());
            sc.write(writebuf);
            System.in.read();//阻塞客户端不结束


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
