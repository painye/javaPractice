package com.company.ThreadPool;

/*
    Executors类中有个创建线程池的方法如下：
        public static ExecutorService newFixedThreadPool(int nThreads)`：返回线程池对象。(创建的是有界线程池,也就是池中的线程个数可以指定最大数量)
        获取到了一个线程池ExecutorService 对象，那么怎么使用呢，在这里定义了一个使用线程池对象的方法如下：
           public Future<?> submit(Runnable task)`:获取线程池中的某一个线程对象，并执行
                Future接口：用来记录线程任务执行毕后产生的结果。线程池创建与使用。

        使用线程池中线程对象的步骤：

        1. 创建线程池对象。
        2. 创建Runnable接口子类对象。(task)
        3. 提交Runnable接口子类对象。(take task)
        4. 关闭线程池(一般不做)。
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());
        es.submit(new Runnable());

    }
}
