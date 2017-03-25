package com.service.impl;

import com.dao.IPerson;
import com.model.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by sunchong on 2016/7/28.
 */
@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private IPerson iPerson;

    public List<Person> findPerson(){
        return iPerson.findPerson();
    }

    public void savePerson(Person person){
        iPerson.savePerson(person);
    }

    public void updatePerson(int id){
        iPerson.updatePerson(id);
    }

    public void deletePerson(int id){
        iPerson.deletePerson(id);
    }

}
