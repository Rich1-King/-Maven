package com.testmemory;

import java.util.UUID;

/**
 * Created by sunchong on 2017/2/6.
 */
public class MemoryDemo{

    public static void main(String[] args){
        Model model = new Model();
        model.setId(UUID.randomUUID().toString());
        Model model1 = model;
        model = null;
        System.out.println(model1.getId());
    }

}
