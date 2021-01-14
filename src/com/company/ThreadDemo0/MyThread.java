package com.company.ThreadDemo0;

public class MyThread extends Thread{
    @Override
    public void run() {
        super.run();
        for(int i=0; i<20; i++){
            System.out.println("run :"+ i);
        }
    }
}
