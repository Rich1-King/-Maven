package com.threadpack;

/**
 * Created by rich1 on 1/12/17.
 */
public class SimpleThread extends Thread{//或者直接继承接口Runnable
    private int i;
    @Override
    public void run(){
        System.out.println("name:"+Thread.currentThread().getName()+", this is "+i+" simple thread");
    }

    public int getI(){
        return i;
    }

    public void setI(int i){
        this.i = i;
    }
}
