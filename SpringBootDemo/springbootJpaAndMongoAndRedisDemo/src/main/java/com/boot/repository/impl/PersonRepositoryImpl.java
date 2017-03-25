package com.boot.repository.impl;

import com.boot.model.po.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by rich1 on 9/9/16.
 */
public class PersonRepositoryImpl{

    @PersistenceContext
    private EntityManager entityManager;

    public PersonRepositoryImpl(){
        System.out.println("what");
    }

    public List<Person> showWord(){
        Query query = entityManager.createQuery("select p from Person as p");
        return (List<Person>)query.getResultList();
    }
}
