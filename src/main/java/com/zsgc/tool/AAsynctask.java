package com.zsgc.tool;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

//异步任务
@Component
@Async
public class AAsynctask {

    public void task1()throws InterruptedException{
        Long begin=System.currentTimeMillis();
        Thread.sleep(5000L);
        Long end=System.currentTimeMillis();
        System.out.println("任务1="+(end-begin));
    }

    public void task2()throws InterruptedException{
        Long begin=System.currentTimeMillis();
        Thread.sleep(5000L);
        Long end=System.currentTimeMillis();
        System.out.println("任务2="+(end-begin));
    }

    public void task3()throws InterruptedException{
        Long begin=System.currentTimeMillis();
        Thread.sleep(5000L);
        Long end=System.currentTimeMillis();
        System.out.println("任务3="+(end-begin));
    }

}
