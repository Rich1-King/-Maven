package com.manyThread.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class ScheduledTaskService{

    private SimpleDateFormat dateFormat = new SimpleDateFormat
            ("HH:mm:ss");
    @Scheduled(fixedRate = 3000)
    public void reportCurrentTime(){
        System.out.println("隔3000秒:"+dateFormat.format(new Date()));
    }
}
