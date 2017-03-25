package com.control;

import com.model.Person;
import com.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by sunchong on 2016/7/26.
 */
@RestController
public class PersonCtrl{

    @Autowired
    PersonService personService;

    @RequestMapping("/show")
    public String show(){
        List<Person> p = personService.findPerson();
        return p.get(0).getName();
    }

}
