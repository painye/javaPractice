package com.company.Tcp;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class SubmitClient {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\dell\\Desktop\\吃面条的女孩4k动漫壁纸_彼岸图网.jpg");
        try {
            Socket sc = new Socket("127.0.0.1", 8888);
            InputStream fi = new FileInputStream(f);
            byte[] bytes = new byte[1024];
            int len=0;
            OutputStream os = sc.getOutputStream();
            os.write("我要开始上传文件了".getBytes());
            while((len=fi.read(bytes))!=-1){//在这里因为我读文件不会读到-1
                os.write(bytes, 0, bytes.length);//所以我不会讲-1写给服务器，所以服务器的read永远读不到-1
            }
            //写入结束标志
            sc.shutdownOutput();

            byte[] bytes1 = new byte[1024];
            InputStream is = sc.getInputStream();
            len = is.read(bytes1);//因为服务器会一直read进入阻塞，其后边的代码写也不会被执行，所以客户端的读也会一直读不到进入阻塞
            System.out.println(new String(bytes1, 0, bytes.length));
            fi.close();
            os.close();
            is.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
