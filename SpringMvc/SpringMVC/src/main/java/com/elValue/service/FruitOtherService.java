package com.elValue.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by rich1 on 7/18/16.
 */
public class FruitOtherService{

    public FruitOtherService(){
        System.out.println("kaishi ");
    }
    @PostConstruct
    public void init(){
        System.out.println("other init");
    }
    @PreDestroy
    public void destory(){
        System.out.println("destory ....");
    }
}
