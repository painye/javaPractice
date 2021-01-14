package com.company.ThreadDemo0;

public class Demo1Thread {
    public static void main(String[] args){
        //main主线程
        for (int i = 0; i <20 ; i++) {
            System.out.println(Thread.currentThread().getName()+"--->"+i);
        }

        //用thread的子类创建线程
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+i);
                }
            }
        }.start();

        //用Runable接口来创建多线程
        Runnable r= new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+i);
                }
            }
        };
        new Thread(r).start();

        //Runable的简化匿名内部类实现
        new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName()+"---->"+i);
                }
            }
        }).start();
    }
}
