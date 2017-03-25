package com;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by sunchong on 2016/7/29.
 */
public class Client{
    public static void main(String[] args){
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                System.out.println("timerTask");
            }
        };

        Timer timer = new Timer();

        long delay = 5000;
        long intevalPeriod = 1 * 1000;
        timer.scheduleAtFixedRate(timerTask, delay, intevalPeriod);
    }
}
