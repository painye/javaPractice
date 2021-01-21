package com.company.Tcp;

/*
    构造方法：
        Socket(String host, int port)创建一个流套接字并将其连接到指定主机上的指定端口
        参数：
            String host:服务器主机的名称/服务器的IP地址
            int post:服务器的端口号
     成员方法：
        OutputStream getOutputStream()返回次套接字的输出流对象
        InputStream getInputStream()返回此套接字的输入刘对象
        void close() 关闭套接字
     实现步骤：
        1、创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        2、使用Socket对象的方法getOutputStream()获取网络字节输出流OutputStream对象
        3、使用网络字节输出流对象OutputStream中的方法write。给服务器发送消息
        4、使用Socket对象的方法getInputStream()获取网络字节输入流对象InputStream
        5、使用网络字节输入流对象InputStream中的方法read.读取服务器回写的数据
        6、释放资源
      注意：
        1、客户端和服务器进行交互必须使用Socket中的网络字节流，不能使用自己创建的流对象
        2、当我们创建客户对象Socket的时候，就回去请求服务器经过三次握手建立连接道路
            这是如果服务器没有启动就会抛出异常
            如果服务器已经启动，那么就可以进行交互了
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        //1、创建一个客户端对象Socket，构造方法绑定服务器的IP地址和端口号
        Socket sc = new Socket("127.0.0.1", 8888);
        //2、使用Socket对象的方法getOutputStream()获取网络字节输出流OutputStream对象
        OutputStream os = sc.getOutputStream();
        //3、使用网络字节输出流对象OutputStream中的方法write。给服务器发送消息
        os.write("你好，服务器".getBytes());
        //4、使用Socket对象的方法getInputStream()获取网络字节输入流对象InputStream
        InputStream is = sc.getInputStream();
        //5、使用网络字节输入流对象InputStream中的方法read.读取服务器回写的数据
        byte[] bytes = new byte[1024];
        int len = is.read(bytes);
        System.out.println(new String(bytes, 0, len));
        //6、释放资源
        sc.close();
    }
}
