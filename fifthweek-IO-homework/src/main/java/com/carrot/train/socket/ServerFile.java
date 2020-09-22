package com.carrot.train.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
    private  static final int PORT=9999;
    private  static final int PORT2=9998;

    public void UpFile() throws IOException {//接受客户端上传的文件，并保存
        try {
            ServerSocket server= new ServerSocket(PORT);
            while(true){
                Socket socket = server.accept();
                DataInputStream is = new  DataInputStream(socket.getInputStream());
                OutputStream os = socket.getOutputStream();
                //1、得到文件名
                String filename="D:\\file\\up\\";
                filename += is.readUTF();
                System.out.println("新生成的文件名为:"+filename);
                FileOutputStream fos = new FileOutputStream(filename);
                byte[] b = new byte[1024];
                int length = 0;
                while((length=is.read(b))!=-1){

                    fos.write(b, 0, length);
                }
                fos.flush();
                fos.close();
                is.close();
                socket.close();
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void DownFile(String filePath){
        try {
            while (true) {
                ServerSocket server= new ServerSocket(PORT2);
                // 选择进行传输的文件
                File fi = new File(filePath);
                System.out.println("文件长度:" + (int) fi.length());
                Socket socket = server.accept();
                System.out.println("建立socket链接");
                DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
                DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
                ps.writeUTF(fi.getName());
                System.out.println(fi.getName());
                ps.flush();
                int bufferSize = 8192;
                byte[] buf = new byte[bufferSize];
                while (true) {
                    int read = 0;
                    if (fis != null) {
                        read = fis.read(buf);
                    }
                    if (read == -1) {
                        break;
                    }
                    ps.write(buf, 0, read);
                }
                ps.flush();
                fis.close();
                socket.close();
                System.out.println("文件传输完成");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String arg[]) throws IOException {
//        new ServerFile().DownFile("D:\\file\\up\\test.txt");
        ServerFile sf=new ServerFile();
//        sf.UpFile();
        System.out.println("开始下载");
        File file = new File("D:\\file\\up\\test.txt");
        System.out.println(file.getName());
        System.out.println("修改文件名test2");
        file.renameTo(new File("D:\\file\\up\\test2.txt"));
        System.out.println("修改文件名成功");
        OutputStream op=new FileOutputStream("D:\\file\\up\\test2.txt");
        op.write("change is 2".getBytes());
        op.flush();
        op.close();
        sf.DownFile("D:\\file\\up\\test2.txt");
    }
}
