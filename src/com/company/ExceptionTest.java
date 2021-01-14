package com.company;

import java.io.IOException;

public class ExceptionTest {
    public  static  void  main(String[] args){
        int[] arr=new int[3];
        int[] arr2=null;
        try{
            int c = getElement(arr2,3);
            System.out.println("主函数中的我还执行嘛");//这句代码不会被执行,因为上一句的代码中产生了异常，JVM不会执行try代码块中的后续语句，转而去执行catch中与产生异常向对应的catch代码块
        }catch (NullPointerException e){
            System.out.println("空指针解决拉");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("索引越界解决拉");
        }
        System.out.println("后续代码1");

        String s="C:\\a.txt";
        try{
            readFile(s);
        }catch (IOException e){
            System.out.println("文件名错误解决了");
        }

        System.out.println("后续代码2");
    }

    public static int getElement(int[] arr, int index){
        if(arr == null) throw new NullPointerException("传递过来的是一个空指针");
        System.out.println("我还执行吗");//如果前面有空指针异常，这个语句不会执行。类似于在这个方法中检测到了异常，该方法直接抛出异常，终止本函数的执行
        if(index<0 || index > arr.length-1) throw new ArrayIndexOutOfBoundsException("索引越界");

        return arr[index];
    }

    public static void readFile(String s) throws IOException {
        if(!s.equals("C:\\a.txt")){
            throw new IOException("找不到该文件");//因为IOException是一个编译期异常其必须要被处理，所以不想上一个函数中的NullException自动抛出到上一级，编译期异常他需要通过thows才能抛向上一
        }
    }
}


