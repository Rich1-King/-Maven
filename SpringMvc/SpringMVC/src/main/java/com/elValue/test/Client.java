package com.elValue.test;

import com.elValue.config.Config;
import com.elValue.service.FruitService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by rich1 on 7/18/16.
 */
public class Client{
    public static void main(String[] args) throws IOException{
        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(Config.class);

        annotationConfigApplicationContext.getEnvironment().setActiveProfiles
                ("one");
        annotationConfigApplicationContext.register(Config.class);
        annotationConfigApplicationContext.refresh();

        FruitService fruitService =
        annotationConfigApplicationContext
        .getBean(FruitService.class);

       /* System.out.println(fruitService.getFruit());
        System.out.println(fruitService.getFruitNum());
        System.out.println(IOUtils.toString(fruitService.getHtml()
                .getInputStream()));*/

        //FruitOtherService fruitOtherService =
        //        annotationConfigApplicationContext.getBean(FruitOtherService
         //               .class);

        annotationConfigApplicationContext.close();
    }
}
