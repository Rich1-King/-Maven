package com.service;

import com.model.Person;

import java.util.List;

/**
 * Created by sunchong on 2016/7/28.
 */
public interface PersonService{
    List<Person> findPerson();

    void savePerson(Person person);

    void updatePerson(int id);

    void deletePerson(int id);
}
