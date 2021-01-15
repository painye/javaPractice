package com.company.ThreadPool;

public class Runnable implements java.lang.Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
