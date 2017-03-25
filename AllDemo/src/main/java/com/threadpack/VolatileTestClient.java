package com.threadpack;

/**
 * Created by sunchong on 2017/1/17.
 */
public class VolatileTestClient{
    public static void main(String[] args){
        VolatileTestThread vatatileTestThread1 = new  VolatileTestThread();
        VolatileTestThread vatatileTestThread2 = new  VolatileTestThread();
        Thread thread1 = new Thread(vatatileTestThread1);
        Thread thread2 = new Thread(vatatileTestThread2);
        thread1.start();
        thread2.start();
        System.out.println("end");
    }
}

class VolatileTestThread implements Runnable{

    /**
     * volatile强制每次都去主内存中获取变量的值，防止值改变，寄存器没有改变，获取的还是改变前的值。volatitle使能够获取到最新的值
     */
    static volatile int value = 10;

    public void run(){
        while(true){
            int a=value;
            System.out.println(a);
            value++;
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
