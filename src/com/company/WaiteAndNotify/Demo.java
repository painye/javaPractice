package com.company.WaiteAndNotify;

public class Demo {
    public static void main(String[] args){
        Baozi bz=new Baozi();
        BaoZiPu bzpu = new BaoZiPu(bz);
        ChiHuo ch=new ChiHuo(bz);

        bzpu.start();
        ch.start();
    }
}
