package com.company.Synchronized;

public class RunableImp implements Runnable{
    private int ticket=100;

    Object obj = new Object();//不能放在run方法中，不然三个线程相当于有了三把锁，在demo中只创建了一个r对象，所以r对象中只有一个obj，在桑格线程中共用了一把同步锁obj
    @Override
    public void run() {
        while(true){
            synchronized (obj){
                if(ticket>0){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"--->"+"正在售卖"+ticket);
                    ticket--;
                }
            else    break;
            }
        }
    }
}
