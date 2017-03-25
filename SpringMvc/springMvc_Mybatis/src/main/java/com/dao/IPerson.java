package com.dao;

import com.model.Person;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunchong on 2016/7/27.
 */
@Resource
@Transactional
public interface IPerson{

    List<Person> findPerson();

    void savePerson(Person person);

    void updatePerson(int id);

    void deletePerson(int id);


}
