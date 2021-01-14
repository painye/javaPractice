package com.company.WaiteAndNotify;

public class ChiHuo extends Thread{
    Baozi bz;
    ChiHuo(Baozi bz){
        this.bz = bz;
    }

    @Override
    public void run() {
        while(true){
            synchronized (bz){
                if(!bz.flag){
                    //如果现在没有包子，吃货等待
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //如果线程被唤醒
                System.out.println("吃货正在吃："+bz.pi+bz.xain+"的包子");
                System.out.println("吃货吃完了"+bz.pi+bz.xain+"的包子");
                System.out.println("-----------------------------------");
                bz.flag = false;
                //唤醒包子铺做包子
                bz.notify();
            }
        }
    }
}
