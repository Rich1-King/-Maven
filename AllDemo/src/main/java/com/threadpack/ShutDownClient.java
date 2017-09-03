package com.threadpack;

/**
 * Created by rich1 on 8/20/17.
 */
public class ShutDownClient{

    public static void main(String[] args){

        Thread thread = new Thread(new Runnable(){

            @Override
            public void run(){
                for(int i=0; i<100; i++){
                    System.out.println("hello" + i);
                    try{
                        Thread.sleep(1000L);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();
        System.out.println("over");
    }

}
