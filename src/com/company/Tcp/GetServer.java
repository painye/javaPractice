package com.company.Tcp;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class GetServer {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\dell\\Desktop\\我的小测试.jpg");
        try {
            ServerSocket ss = new ServerSocket(8888);
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

            sc.getOutputStream().write("上传成功".getBytes());
            fs.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
