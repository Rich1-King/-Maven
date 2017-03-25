package com.threadpack;

import org.apache.log4j.Logger;

/**
 * Created by sunchong on 2017/3/3.
 */
public class MoreThreadBreakClient{
    static Logger logger = Logger.getLogger(MoreThreadBreakClient.class);
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable(){
            public void run(){
                for(int i=0; i<10000; i++){
                  logger.info("线程hello" + i);
                }
            }
        });
        thread.start();
        logger.info("在主线程中");
        logger.info("主线程中");
    }
}
