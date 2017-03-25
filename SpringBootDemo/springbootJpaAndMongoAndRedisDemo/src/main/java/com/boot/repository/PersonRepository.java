package com.boot.repository;

import com.boot.model.po.Person;
import com.boot.model.vo.PersonBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rich1 on 9/9/16.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person,String>,
        JpaSpecificationExecutor{

     Person findById(String id);

     List<Person> findByName(String name);

     List<Person> findAll();

     List<Person> showWord();

     //Page<Person> findAll(Filter filter);

    @Query("Select new com.boot.model.vo.PersonBean(p.id, p.name, p.age) from Person as p where p = :id")
    PersonBean findPersonBean(@Param(value = "id") String id);

    //错误命名
    //int countByAgeIs20();
}
