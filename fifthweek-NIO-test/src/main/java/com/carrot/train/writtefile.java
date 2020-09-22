package com.carrot.train;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class writtefile {
    @Test
    public  void  testniowrite() {
        try {
            FileOutputStream file1 = new FileOutputStream("basic.txt");
            FileChannel fc = file1.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String str = "hello.info";
            buffer.put(str.getBytes());
            buffer.flip();
            fc.write(buffer);
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testnioread() {
        try {
            /*FileOutputStream file1 = new FileOutputStream("basic.txt");*/
            FileInputStream file1=new FileInputStream("basic.txt");
            FileChannel fc = file1.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fc.read(buffer);
            System.out.println(new String(buffer.array()));
            file1.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testniocopy() {

        try {

            FileInputStream fi = new FileInputStream("basic.txt");
            FileOutputStream fo = new FileOutputStream("basic1.txt");
            FileChannel source = fi.getChannel();
            FileChannel transf = fo.getChannel();
            transf.transferFrom(source, 0, source.size());
            fi.close();
            fo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
