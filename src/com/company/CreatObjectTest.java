package com.company;

public class CreatObjectTest {
    public static  void main(String[] args){
    Demo d = new Demo();
    }
}

class Demo{
    static int x=1;
    int  y=1;
    static{//静态代码块
        x = 2;
        System.out.println("static code x = "+x);
    }

    {//构造代码块
        System.out.println("cons code y = "+y);
    }

    Demo(){
        System.out.println("cons function y = "+y);
    }

}
