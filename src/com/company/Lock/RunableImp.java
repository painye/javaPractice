package com.company.Lock;
/*
    解决线程安全性问题的第三中方式：lock锁
    1、创建一个ReentrantLock对象，以便调用lock的方法
    2、在同步代码（访问共享数据调用前）调用lock方法获得锁
    3、在同步代码调用后释放锁
 */

import java.util.concurrent.locks.ReentrantLock;

public class RunableImp implements Runnable{
    private int ticket=100;
    ReentrantLock l=new ReentrantLock();
    @Override
    public void run() {

        System.out.println("this: "+this);
        while(true){
            l.lock();
            if(ticket>0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"--->"+"正在售卖"+ticket);
                ticket--;
            }
            l.unlock();
        }
    }

}
