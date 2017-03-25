package com.boot.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by rich1 on 11/18/16.
 */
public class FatherRepositoryImpl{

    @Autowired
    EntityManager entityManager;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List testLeftJoin() throws Exception{
        String sql = "select f.*, count(s.fid) as total from father as f " +
                "left" +
                " " +
                "join son as s on f.fid = s.fid group by f.fid order by total" +
                " asc";
        Query query = entityManager.createNativeQuery(sql);
        List list = query.getResultList();
        entityManager.close();
        System.out.println("结束");
        return list;
    }
}
