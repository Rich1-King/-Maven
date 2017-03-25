package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by sunchong on 2016/7/29.
 */
public class ThreadPoolClient{
    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable(){
            public void run(){
                System.out.println("hello");
            }
        });




    }
}
