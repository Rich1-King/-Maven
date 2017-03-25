package com.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by sunchong on 2016/7/29.
 */
@Service
public class TaskService{

   // @Scheduled(fixedRate = 10)
    public void sayHello(){
        System.out.println("hello");
    }

    @Scheduled(cron = "0 57 15 * * ?")
    public void useTask(){
        System.out.println("11:35");
    }
/*
    @Async
    public void executeAsynctask(int i){
        System.out.println("执行异步任务:" + i);
    }

    @Async
    public void executeAsyncTaskPlus(int i){
        System.out.println("执行新的异步任务:" + i);
    }
*/
}
