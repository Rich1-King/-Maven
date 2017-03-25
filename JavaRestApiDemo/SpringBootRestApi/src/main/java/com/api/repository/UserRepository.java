package com.api.repository;

import com.api.model.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by sunchong on 2017/2/21.
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor{

    boolean createTable();

}
