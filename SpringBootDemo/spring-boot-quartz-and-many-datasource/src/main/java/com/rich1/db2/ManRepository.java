package com.rich1.db2;


import com.rich1.po.db2.Man;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by sunchong on 2016/12/8.
 */
@Repository
public interface ManRepository extends JpaRepository<Man, String>, JpaSpecificationExecutor{
}
