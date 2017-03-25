package com.manyThread.test;

import com.manyThread.config.TaskExecutorConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rich1 on 7/18/16.
 */
public class TaskClient{

    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TaskExecutorConfig
                .class);

    }
}
