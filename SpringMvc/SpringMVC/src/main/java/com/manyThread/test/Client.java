package com.manyThread.test;

import com.manyThread.config.TaskExecutorConfig;
import com.manyThread.service.AsyncTaskService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rich1 on 7/18/16.
 */
public class Client{
    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(TaskExecutorConfig
                .class);

        AsyncTaskService asyncTaskService =
                annotationConfigApplicationContext.getBean(AsyncTaskService
                        .class);
        for(int i=0; i<10; i++)
        {
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }

        annotationConfigApplicationContext.close();
    }
}
