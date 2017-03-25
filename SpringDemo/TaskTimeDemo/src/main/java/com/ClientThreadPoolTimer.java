package com;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by sunchong on 2016/7/29.
 */
public class ClientThreadPoolTimer{
    public static void main(String[] args){
        Runnable runnable = new Runnable(){
            public void run(){
                System.out.println("ClientThreadPoolTimer");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 5, 1,TimeUnit.SECONDS);
    }
}
