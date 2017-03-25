package com.spring.service;

import com.spring.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by rich1 on 7/18/16.
 */
@Service
public class PersonService{

    @Autowired
    Person person;

    public String SayWord(String word)
    {
        return person.sayWord(word);
    }
}
