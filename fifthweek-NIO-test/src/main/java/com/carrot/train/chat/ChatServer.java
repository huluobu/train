package com.carrot.train.chat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.SimpleTimeZone;

public class ChatServer {
    private ServerSocketChannel serverSocketChannel;
    private Selector selector;
    private  static final int PORT=9999;

    public ChatServer() {
        try {
            serverSocketChannel = ServerSocketChannel.open();
            selector = Selector.open();
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            printInfo("chat is already");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
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
                    socketChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println(socketChannel.getRemoteAddress().toString().substring(1) + "online ...");
                }
                if (selectionKey.isReadable()) {
                   readMsg(selectionKey);
                }
                keyiterator.remove();
            }
        }


    }

    public void readMsg(SelectionKey key) throws IOException {
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int count = channel.read(buffer);
        if (count > 0) {
            String msg=new String(buffer.array());
            printInfo(msg);
            broadCastMsg(channel, msg);
        }
    }

    public void broadCastMsg(SocketChannel sc, String msg) throws IOException {
        System.out.println("服务器发送广播");
        for (SelectionKey key : selector.keys()) {
            Channel targetchannel = key.channel();
            if ( targetchannel instanceof SocketChannel && targetchannel != sc) {
                SocketChannel deschannel = (SocketChannel) targetchannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                deschannel.write(buffer);
            }
        }
    }


    public void printInfo(String msg) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("[" + sdf.format(new Date()) + "]-->:" + msg);
    }

    public static void main(String[] args) throws IOException {
        new ChatServer().start();
    }
}
