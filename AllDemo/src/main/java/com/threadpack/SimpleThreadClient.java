package com.threadpack;

/**
 * Created by rich1 on 2/13/17.
 */
public class SimpleThreadClient{

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                try{
                    synchronized (this){
                        wait(1);
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("this is 子线程");
            }
        });

        t1.start();
        synchronized (t1){
            try{
                //wait方法只能运行在同步代码块中,如果没有锁则会抛出异常,类似的方法还有notity(唤醒进程,并获取对象锁)
                t1.wait(1); //wait方法是让当前cpu运行的线程挂起(主线挂起，并释放主线程中的t1锁，线程t1正常运行)
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        synchronized (t1){
            //notify的作用是唤醒一个任意需要t1锁线程,并将ｔ1锁给它
            t1.notify();
        }
        //join方法依赖于wait方法实现，当t1线程存活，则一直调用wait方法，阻塞当前正在运行的线程，因为当前正在运行的线程没有释放锁，所以不会改变，即主线程
        //t1.join();//join方法,将ｔ1线程加入正在运行的线程，并阻塞主线程，当t1线程运行结束，继续运行主线程
        System.out.println("this　is 主线程");
    }
}
