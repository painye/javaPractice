package com.company.ThreadSafeDemo01;

public class ThreadSafeDemo0 {
    public static void main(String[] args){
        RunableImp r= new RunableImp();//只创建一个runnable实例，因为要共享ticket
        System.out.println("run: "+r);
        Thread t0=new Thread(r);
        Thread t1=new Thread(r);
        Thread t2=new Thread(r);
        t0.start();
        t1.start();
        t2.start();
    }
}
