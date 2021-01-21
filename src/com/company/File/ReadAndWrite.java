package com.company.File;

import java.io.*;

public class ReadAndWrite {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\dell\\Desktop\\吃面条的女孩4k动漫壁纸_彼岸图网.jpg");
        File myF = new File("C:\\Users\\dell\\Desktop\\11111.jpg");
        try {
            FileInputStream is = new FileInputStream(f);
            FileOutputStream os = new FileOutputStream(myF);
            byte[] bytes = new byte[1024];
            int len=0;
            while((len=is.read(bytes))!=-1){
                os.write(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
