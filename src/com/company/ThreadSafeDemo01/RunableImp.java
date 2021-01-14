package com.company.ThreadSafeDemo01;

public class RunableImp implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        System.out.println("this: "+this);
        while(true){
            payTicket();
        }
    }

    public synchronized void payTicket(){
        /*
            同步方法的锁对象其实就是这个类的实现类，也就是对象，即调用该方法的对象本身，this
         */
        if(ticket>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"--->"+"正在售卖"+ticket);
            ticket--;
        }
    }
}
