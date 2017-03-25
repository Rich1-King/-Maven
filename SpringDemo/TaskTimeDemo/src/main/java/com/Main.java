package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sunchong on 2016/7/29.
 */
public class Main{

    public static void main(String[] args){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(com.config.TaskConfig.class);

        //TaskService taskService = annotationConfigApplicationContext.getBean(TaskService.class);

        /*for(int i=0; i<5; i++){
            taskService.executeAsynctask(i);
            taskService.executeAsyncTaskPlus(i);
        }*/
        //taskService.useTask();
       // taskService.sayHello();
        //annotationConfigApplicationContext.close();
        System.out.println("It is over！！");
    }
}
