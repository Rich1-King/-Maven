package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@Service
@Transactional
public class PersonService{

    @Autowired
    PersonRepository personRepository;

    public List<Person> getPersons(){
        return personRepository.findAll();
    }
}
