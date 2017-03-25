package com.rich1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by sunchong on 2016/12/8.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryPrimary",
        transactionManagerRef="transactionManagerPrimary",
        basePackages= { "com.rich1.model.po.db2","com.rich1.repository" })
public class DatasourceDb2Config{
        @Autowired
        @Qualifier("db2DataSource")
        private DataSource db2Datasource;

        @Bean(name = "entityManagerPrimary")
        public EntityManager entityManager(EntityManagerFactoryBuilder builder){
                return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
        }

        @Bean(name = "entityManagerFactoryPrimary")
        public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder){
                return builder.dataSource(db2Datasource)
                      .properties(getVendorProperties(db2Datasource))
                      .packages("com.rich1.model.po.db2","com.rich1.repository.db2")//数据源实体类所在包
                      .persistenceUnit("db2PersistenceUnit")
                      .build();
        }

        @Autowired
        private JpaProperties jpaProperties;

        private Map<String, String> getVendorProperties(DataSource dataSource){
                return jpaProperties.getHibernateProperties(dataSource);
        }

        @Bean(name = "transactionManagerPrimary")
        public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder){
               return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
        }
}
