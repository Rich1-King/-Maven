package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rich1 on 9/20/16.
 */
@Repository
public interface UserRepository extends JpaRepository<User,String>{

}
