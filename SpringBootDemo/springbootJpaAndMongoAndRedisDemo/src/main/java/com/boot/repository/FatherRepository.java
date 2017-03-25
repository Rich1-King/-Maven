package com.boot.repository;

import com.boot.model.po.Father;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rich1 on 10/10/16.
 */
@Repository
public interface FatherRepository extends JpaRepository<Father,String>,
        JpaSpecificationExecutor{
   /* @Query("select f,count(s) as total from Father as f left join f" +
            ".sons as s " +
            "where " +
            "f" +
            ".fid=s" +
            ".fid group by f.fid order by total desc")
    Page<Father> findByQuery(Pageable pageable);*/

    int countByFid(String fid);

    List testLeftJoin() throws Exception;
}
