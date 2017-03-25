package com.spring.bean;

import org.springframework.stereotype.Service;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class Person{

    public String sayWord(String word)
    {
        return "hello" + word;
    }

}
