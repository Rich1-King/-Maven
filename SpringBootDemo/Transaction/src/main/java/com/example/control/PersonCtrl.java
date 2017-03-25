package com.example.control;

import com.example.model.Person;
import com.example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@RestController
public class PersonCtrl{

    @Autowired
    PersonService personService;

    @RequestMapping("person")
    public List<Person> getPerson(){
        return personService.getPersons();
    }
}
