package com.aop.test;

import com.aop.actionService.DemoAnnotationService;
import com.aop.actionService.DemoMethodService;
import com.aop.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rich1 on 7/18/16.
 */
public class Client{

    public static void main(String[] args){

        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(Config.class);

        DemoAnnotationService demoAnnotationService =
        annotationConfigApplicationContext.getBean
                (DemoAnnotationService
                .class);

        DemoMethodService demoMethodService =
                annotationConfigApplicationContext.getBean(DemoMethodService
                        .class);

        demoAnnotationService.add();

        demoMethodService.add();

        annotationConfigApplicationContext.close();
    }
}
