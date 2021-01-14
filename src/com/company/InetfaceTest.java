package com.company;

public class InetfaceTest {
    public static void main(String[] args){
        C c = new C();
        c.show();
    }
}

interface  A{
    abstract  void show();
}

interface  B{
    abstract  void show();
}

class C implements A,B{

    @Override
    public void show() {
        System.out.println("我能不能被实例化");
    }
}

