package com.api.repository.impl;

import com.api.interceptor.SqlInterceptor;
import com.api.model.po.User;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by sunchong on 2017/2/21.
 */
public class UserRepositoryImpl{

//    @Autowired
//    HibernateTemplate hibernateTemplate;

    @Autowired
    EntityManager entityManager;

    public boolean createTable(){
        Session session = entityManager.unwrap(org.hibernate.Session.class);
        session.doWork(new Work(){
            @Override
            public void execute(Connection connection) throws SQLException{
                String tableName = User.class.getAnnotation(Table.class).name();
                String sql = "create table " + tableName +" like user";
                sql = SqlInterceptor.sqlFilter(sql);
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.execute();
                preparedStatement.close();
            }
        });
        return true;
    }
}
