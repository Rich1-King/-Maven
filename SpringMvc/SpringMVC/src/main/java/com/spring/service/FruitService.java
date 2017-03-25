package com.spring.service;

import com.spring.bean.Fruit;

/**
 * Created by rich1 on 7/18/16.
 */
public class FruitService{

    Fruit fruit;

    public void setFruit(Fruit fruit)
    {
        this.fruit = fruit;
    }

    public String FruitType(String type)
    {
        return fruit.fruitType(type);
    }
}
