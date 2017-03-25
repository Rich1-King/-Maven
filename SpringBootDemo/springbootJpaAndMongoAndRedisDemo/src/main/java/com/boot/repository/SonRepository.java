package com.boot.repository;

import com.boot.model.po.Son;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rich1 on 9/11/16.
 */
@Repository
public interface SonRepository extends JpaRepository<Son,String>,
        JpaSpecificationExecutor{
    Son findBySid(String sid);

    List<Son> findAll();

    List<Son> findByFid(String fid);

    int countByFid(String fid);

    //int countByFid(String fid,Specification specification); //不可以
}
