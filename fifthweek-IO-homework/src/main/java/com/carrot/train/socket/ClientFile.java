package com.carrot.train.socket;

import java.io.*;
import java.net.Socket;

public class ClientFile {
    private  final String HOST = "127.0.0.1";
    private  final int PORT = 9999;
    private  final int PORT2 = 9998;

    public void UpFile(String filePath){
        //上传文件，将本地文件传输到服务器端
        try {
            Socket socket = new Socket(HOST,PORT);
            while (true) {
                // 选择进行传输的文件
                File fi = new File(filePath);
                System.out.println("文件长度:" + (int) fi.length());

                DataInputStream fis = new DataInputStream(new BufferedInputStream(new FileInputStream(filePath)));
                DataOutputStream ps = new DataOutputStream(socket.getOutputStream());
                ps.writeUTF(fi.getName());
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
    public void DownFile(){
        try {
            Socket socket = new Socket(HOST,PORT2);
            while(true){
                DataInputStream is = new  DataInputStream(socket.getInputStream());
                OutputStream os = socket.getOutputStream();
                //1、得到文件名
                String filename="D:\\file\\down\\";
                filename += is.readUTF();
                System.out.println("新生成的文件名为:"+filename);
                FileOutputStream fos = new FileOutputStream(filename);
                byte[] b = new byte[1024];
                int length = 0;
                while((length=is.read(b))!=-1){
                    //2、把socket输入流写到文件输出流中去
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

    public static void main(String arg[]) throws IOException {
        String filepath="D:\\file\\current\\test.txt";
//        File dir1 = new File(filepath);
//        if (dir1.exists()) {     // 如果D:/IOTest/dir1不存在，就创建为目录
//            System.out.println("存在");
//        }
//        File file = new File(dir1,"test.txt");
//        file.createNewFile();


        ClientFile cf = new ClientFile();
//        cf.UpFile(filepath);
        System.out.println("开始下载");
        cf.DownFile();
    }
}
