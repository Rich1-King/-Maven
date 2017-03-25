package com.elValue.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class Fruit{

    @Value("orange")
    private String fruitType;

    @Value("5")
    private int fruitNum;

    public int getFruitNum(){
        return this.fruitNum;
    }

    @Value("http://www.baidu.com")
    private Resource htmlText;

    public Resource getHtmlText(){
        return this.htmlText;
    }

   /* public void setFruitType(String fruitType){
        this.fruitType = fruitType;
    }*/

    public String getFruitType(){
        return this.fruitType;
    }



    public String getFruit(){
        return getFruitType();
    }

    public int getNum(){
        return getFruitNum();
    }

    public Resource getText()
    {
        return getHtmlText();
    }

}
