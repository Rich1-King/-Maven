package com.boot.service;

import com.boot.model.po.Person;

import java.util.Calendar;

/**
 * Created by rich1 on 3/29/17.
 */
public interface PersonService{

    void updateNameAndAge(String id, String name, int age) throws Exception;

    void savePerson(Person person) throws Exception;

    void updateAndInsert(String id, String name, int age) throws Exception;

    void update2DelTrue(Calendar startTime, Calendar endTime) throws Exception;

}
