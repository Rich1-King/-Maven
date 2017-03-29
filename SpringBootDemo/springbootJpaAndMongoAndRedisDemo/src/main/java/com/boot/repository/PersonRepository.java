package com.boot.repository;

import com.boot.model.po.Person;
import com.boot.model.vo.PersonBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
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

    @Modifying
    @Query("update Person p set p.name=:name, p.age=:age where p.id=:id")
    void updateNameAndAge(@Param("id") String id,@Param("name") String name, @Param("age") int age);

    @Modifying
    @Query("update Person p set p.del=true where p.del=false and p.createTime >=:startTime and p.createTime <=:endTime")
    void update2DelTrue(@Param("startTime") Calendar startTime,@Param("endTime") Calendar endTime);

    //错误命名
    //int countByAgeIs20();
}
