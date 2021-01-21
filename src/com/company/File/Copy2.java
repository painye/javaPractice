package com.company.File;

import java.io.*;

public class Copy2 {
    public static void main(String[] args) {
        File f1 = new File("C:\\Users\\dell\\Desktop\\大四寒假学习笔记\\JDBC\\JDBC课堂笔记\\JDBC课堂笔记.txt");
        File f2 = new File("C:\\Users\\dell\\Desktop\\3.txt");
        try {
            InputStream fi = new FileInputStream(f1);
            OutputStream fo = new FileOutputStream(f2);
            InputStreamReader fr = new InputStreamReader(fi, "UTF-8");
            OutputStreamWriter fw = new OutputStreamWriter(fo, "UTF-8");
            int length = 0;
            char[] cbuff = new char[1024];
            length = fr.read(cbuff);
            System.out.println("sdasdsa");
            fw.write(cbuff,0, cbuff.length);
            fr.close();
            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
