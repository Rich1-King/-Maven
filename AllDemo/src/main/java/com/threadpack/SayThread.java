package com.threadpack;

import java.util.concurrent.Callable;

/**
 * Created by rich1 on 11/3/16.
 */
public class SayThread implements Callable<Object>{

    public int time;

    public SayThread(int time){
        this.time = time;
    }
    //该对线程允许具有返回值
    public Object call() throws Exception{
        System.out.println(Thread.currentThread().getName()+", time:"+time+"success");
//        if(time == 0){
//            Thread.sleep(10000);
//        }
        return Thread.currentThread().getName()+", time:"+time+"success";
    }

}
