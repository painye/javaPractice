package com.company.Tcp;

/*
    TCP通信的服务端：接收客户端的请求，读取客户端所发送的数据，给客户端回写数据
    表示服务器的类：
        java.net.ServerSocket：此类实现服务其套接字
     构造方法：
        ServerSocket(int port) 创建指定端口号的服务器套接字

     服务器段必须明确一件事，必须得知道是哪个客户端请求的服务器
     所以可以通过使用accept方法获取到请求的客户端对象Socket
     成员方法：
        Socket accept() 侦听并接收到此套接字的连接

     服务器的实现步骤：
        1、创建服务器ServerSocket对象和系统要指定的端口号
        2、使用serverSocket对象中的方法accept来获取请求的客户端的Socket对象
        3、使用Socket对象中的getInputStream()方法获取到网络字节流InputSream对象
        4、使用网络套接字InputStream中的read方法读取客户端发送的数据
        5、使用Socket对象中的getOutputStream()方法获取到网络字节流OutputStream对象
        6、使用网络字节流OutputStream中的write方法想客户端回写数据
        7、关闭资源
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        //1、创建服务器ServerSocket对象和系统要指定的端口号
        ServerSocket ss = new ServerSocket(8888);
        //2、使用serverSocket对象中的方法accept来获取请求的客户端的Socket对象
        Socket sc = ss.accept();
        // 3、使用Socket对象中的getInputStream()方法获取到网络字节流InputSream对象
        InputStream is = sc.getInputStream();
        //4、使用网络套接字InputStream中的read方法读取客户端发送的数据
        byte[] bytes= new byte[1024];
        int len= is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //5、使用Socket对象中的getOutputStream()方法获取到网络字节流OutputStream对象
        OutputStream os = sc.getOutputStream();
        //6、使用网络字节流OutputStream中的write方法想客户端回写数据
        os.write("收到谢谢".getBytes());
        //7、关闭资源
        sc.close();
        ss.close();
    }
}
