package com.elValue.service;


import com.elValue.bean.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

/**
 * Created by rich1 on 7/18/16.
 */

public class FruitService{
    public FruitService()
    {
        System.out.println("runing init...");
    }

    @Autowired
    Fruit fruit;

    public String getFruit(){
       return fruit.getFruit();
    }

    public int getFruitNum(){
        return fruit.getFruitNum();
    }

    public Resource getHtml()
    {
        return fruit.getHtmlText();
    }

    public void init()
    {
        System.out.println("Initialization");
    }

    public void destroy()
    {
        System.out.println("destory");
    }



}
