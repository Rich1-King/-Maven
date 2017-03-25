package com.content.repository;

import com.content.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rich1 on 10/16/16
 */
public interface UserRepository extends JpaRepository<User, String>{
    User findByUsername(String username);
}
