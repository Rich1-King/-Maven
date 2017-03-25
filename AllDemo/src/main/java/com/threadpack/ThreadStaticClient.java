package com.threadpack;

/**
 * Created by rich1 on 2/15/17.
 */
public class ThreadStaticClient{

    volatile static Integer i = 0;
    static Value v = new Value();

    public static void main(String[] args){
        //线程的切换可能会造成后面输出的数小于前面的,因为java的自动装箱和拆箱，导致i的内存地址改变，所以不同线程指定的是不同线程。
//        for(int j=0; j<100; j++){
//            Thread thread = new Thread(new Runnable(){
//                public void run(){
//                    synchronized (i){
//                        System.out.println("i value :" + (++i));
//                    }
//                }
//            });
//            thread.start();
//        }
        //该对象会被锁定，输出的值自增
        for(int j=0; j<100; j++){
            Thread thread = new Thread(new Runnable(){
                public void run(){
                    synchronized (v){
                        System.out.println("i value :" + (++v.i));
                    }
                }
            });
            thread.start();
        }
    }
}

class Value{
    public int i = 0;
}


