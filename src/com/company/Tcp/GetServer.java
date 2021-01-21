package com.company.Tcp;

import org.junit.Test;

import javax.xml.crypto.Data;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class GetServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(8888);
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--》run");
                while(true){
                    String filepath = "C:\\Users\\dell\\Desktop\\我的测试\\";
                    Random r= new Random();
                    String filename = filepath+System.currentTimeMillis()+r.nextInt(999999)+".jpg";
                    File f = new File(filename);
                    try {
                        OutputStream fs = new FileOutputStream(f);
                        Socket sc = ss.accept();
                        InputStream is = sc.getInputStream();
                        byte[] bytes = new byte[1024];
                        int len = 0;
                        is.read(bytes, 0, bytes.length);
                        System.out.println(new String(bytes, 0, bytes.length));
                        while ((len=is.read(bytes))!=-1){//服务器永远也读不到-1，就永远不会停止，以智慧陷入阻塞状态，气候变得代码也不会被执行
                            fs.write(bytes, 0, bytes.length);
                        }

                        sc.getOutputStream().write((Thread.currentThread().getName()+"--》run"+"上传成功").getBytes());
                        fs.close();
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
        while(true){
            String filepath = "C:\\Users\\dell\\Desktop\\我的测试\\";
            Random r= new Random();
            String filename = filepath+System.currentTimeMillis()+r.nextInt(999999)+".jpg";
            File f = new File(filename);
            try {
                OutputStream fs = new FileOutputStream(f);
                Socket sc = ss.accept();
                InputStream is = sc.getInputStream();
                byte[] bytes = new byte[1024];
                int len = 0;
                is.read(bytes, 0, bytes.length);
                System.out.println(new String(bytes, 0, bytes.length));
                while ((len=is.read(bytes))!=-1){//服务器永远也读不到-1，就永远不会停止，以智慧陷入阻塞状态，气候变得代码也不会被执行
                    fs.write(bytes, 0, bytes.length);
                }

                sc.getOutputStream().write((Thread.currentThread().getName()+"--》main"+"上传成功").getBytes());
                fs.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
