package com.boot.service.impl;

import com.boot.model.po.Person;
import com.boot.repository.PersonRepository;
import com.boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by rich1 on 3/29/17.
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateNameAndAge(String id, String name,int age) throws Exception{
        personRepository.updateNameAndAge(id, name, age);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePerson(Person person){
        personRepository.save(person);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAndInsert(String id,String name,int age) throws Exception{
        personRepository.updateNameAndAge(id, name, age);
        Person person = new Person();
        person.setId("0004");
        person.setName("newAdd");
        person.setAge(10);
        personRepository.save(person);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update2DelTrue(Calendar startTime,Calendar endTime) throws Exception{
        personRepository.update2DelTrue(startTime, endTime);
        Person person = new Person();
        person.setId("0005");
        person.setName("newAdd1");
        person.setAge(12);
        personRepository.save(person);
    }
}
