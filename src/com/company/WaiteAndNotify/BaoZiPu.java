package com.company.WaiteAndNotify;

public class BaoZiPu extends Thread{
    //包子铺要生产包子，所需一他需要一个成员变量是包子
    Baozi bz;

    BaoZiPu(Baozi bz){
        this.bz = bz;
    }

    /*
        包子铺的任务就是：
            当前有包子：  等待
            五包子： 做包子，做好包子后唤醒吃货吃包子
     */
    @Override
    public void run() {
        int count=0;
        while(true){
            synchronized (bz){
                if(bz.flag){
                    //现在有包子，等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //现在没有包子，被唤醒了，需要做包子
                if(count%2==0){
                    bz.pi="薄皮";
                    bz.xain="三鲜陷";
                }else {
                    bz.pi="冰皮";
                    bz.xain="牛肉大葱陷";
                }

                System.out.println("包子铺正在制作： "+bz.pi+bz.xain+"的包子");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                bz.flag = true;
                count++;
                System.out.println(bz.pi+bz.xain+"的包子已经做好了，可以吃了");
                bz.notify();
            }
        }
    }
}
