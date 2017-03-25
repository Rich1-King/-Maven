package com.boot.repository;

import com.boot.model.po.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by rich1 on 11/5/16.
 */
public interface RoleRepository extends JpaRepository<Role, String>,
        JpaSpecificationExecutor{

    List<Role> findAll();
}
