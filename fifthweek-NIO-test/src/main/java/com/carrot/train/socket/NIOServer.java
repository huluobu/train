package com.carrot.train.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    public static void main(String[] args) {
        try {
            ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
            Selector selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(9999));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            while (true) {

                if (selector.select(2000)==0) {
//                    监控客户端
                    System.out.println("server:没有客户端请求");
                    continue;
                }
                Iterator<SelectionKey> keyiterator = selector.selectedKeys().iterator();
                while (keyiterator.hasNext()) {
                    SelectionKey selectionKey = keyiterator.next();
                    if (selectionKey.isAcceptable()) {
                        System.out.println("OP_ACCEPT");
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                    }
                    if (selectionKey.isReadable()) {
                        SocketChannel channel = (SocketChannel) selectionKey.channel();
                        ByteBuffer buffer = (ByteBuffer) selectionKey.attachment();
                        channel.read(buffer);
                        System.out.println("客户发送的数据为："+new String(buffer.array()));
                    }
                    keyiterator.remove();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
