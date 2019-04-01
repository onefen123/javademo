package com.zsgc.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableScheduling
public class MyTask {
    @Scheduled(cron="*/60 * * * * *")
    public void task1(){
        System.out.println("task1");
    }

}
