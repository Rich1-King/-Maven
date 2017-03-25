package com.spring.test;

import com.spring.config.FruitConfig;
import com.spring.config.PersonConfig;
import com.spring.service.FruitService;
import com.spring.service.PersonService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by rich1 on 7/18/16.
 */
public class Client{
    public static void main(String[] args){

        AnnotationConfigApplicationContext annotationConfigApplicationContext
                = new AnnotationConfigApplicationContext(PersonConfig.class);
        PersonService personService = annotationConfigApplicationContext.getBean(PersonService.class);

        System.out.println(personService.SayWord("word"));

        annotationConfigApplicationContext.close();

        annotationConfigApplicationContext = new
                AnnotationConfigApplicationContext(FruitConfig.class);
        FruitService fruitService = annotationConfigApplicationContext.getBean
                (FruitService
                .class);

        System.out.println(fruitService.FruitType("apple"));

        annotationConfigApplicationContext.close();



    }
}
