package com.zsgc.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@EnableScheduling
public class MyDynamicTask {
    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture<?> future;
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
        return new ThreadPoolTaskScheduler();
    }
    @RequestMapping("/starttask")
    public String startTask(){
        future=threadPoolTaskScheduler.schedule(new MyRunnable(),new CronTrigger("*/1 * * * * *"));
        System.out.println("start");
        return "start";
    }

    private class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("dynamictask!!!");
        }
    }

    @RequestMapping("/stoptask")
    public String stopTask(){
        if(future !=null){
            future.cancel(true);
        }
        return "stop!!";
    }

    @RequestMapping("/changetask/{t}")
    public String changeTask(@RequestParam(defaultValue ="5" ,required = true)int t){
        stopTask();
        future=threadPoolTaskScheduler.schedule(new MyRunnable(),new CronTrigger("*/"+t +" * * * * *"));
        System.out.println("changeTask!!!");
        return "changetask!!";

    }
}
