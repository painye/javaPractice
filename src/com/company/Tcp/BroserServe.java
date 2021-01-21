package com.company.Tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BroserServe {
    public static void main(String[] args) throws IOException {
        //端口为8080，也就是说这哥服务器的地址：端口为 127.0.0.1:8080
        ServerSocket ss = new ServerSocket(8080);
        //获取发出请求的客户端的socket
        Socket sc = ss.accept();
        //获取当前客户端的网络字节输入流
        InputStream is = sc.getInputStream();

       /*
        while ((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes, 0, len));
        }
        */
        //利用该流缓冲字符流来实现读一行
        BufferedReader bis = new BufferedReader(new InputStreamReader(is));
        String path = bis.readLine();//   Get  /untitled/web/index.html
        String[] arr = path.split(" "); // /untitled/web/index.html
        path = arr[1].substring(1); // untitled/web/index.html
        System.out.println(path);

        //创建一个本地的字节输入流用来读取本地的HTML文件
        FileInputStream fis = new FileInputStream(path);

        //获取客户端的网络字节输出流
        OutputStream os = sc.getOutputStream();

        // 写入HTTP协议响应头,固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        os.write("\r\n".getBytes());

        //一读一写
        byte[] bytes = new byte[1024];
        int len=0;
        while((len = fis.read(bytes))!=-1){
            os.write(bytes, 0, len);
        }

        fis.close();
        is.close();
        os.close();
        bis.close();
        sc.close();


        //ss.close();

    }
}
