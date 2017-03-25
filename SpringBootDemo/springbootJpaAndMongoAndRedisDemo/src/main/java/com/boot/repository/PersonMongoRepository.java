package com.boot.repository;

import com.boot.model.po.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rich1 on 9/10/16.
 */
@Repository
public interface PersonMongoRepository extends MongoRepository<Person,String>{

}
