package com.boot.repository.impl;

import com.boot.model.po.Father;
import com.boot.model.po.Son;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.List;

/**
 * Created by rich1 on 9/11/16.
 */
public class SonRepositoryImpl{

   //方法一
    @PersistenceContext
    private EntityManager entityManager;

    JpaSpecificationExecutor jpaSpecificationExecutor = null;

   /*//方法二
    @Autowired
    SonRepository jpaSpecificationExecutor;
    */
    public List<Son> findByFid(String fid){
        jpaSpecificationExecutor = new
                SimpleJpaRepository(Son.class,entityManager);//方法一

      return jpaSpecificationExecutor.findAll(new Specification<Son>(){
            @Override
            public Predicate toPredicate(Root root,CriteriaQuery criteriaQuery,CriteriaBuilder criteriaBuilder){
                Join join = root.join(root.getModel().getSingularAttribute
                       ("father",Father.class));
                //Root join = criteriaQuery.from(Father.class);
                return criteriaBuilder.equal(join.get("fid").as(String.class),
                        fid);
            }
        });

    }
}
