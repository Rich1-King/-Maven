package com.rich1.service;

import com.juxinli.demo.quartz.springboot.model.po.db2.Man;
import com.juxinli.demo.quartz.springboot.repository.db2.ManRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sunchong on 2016/12/8.
 */
@Service
public class ManService{

    @Autowired
    ManRepository manRepository;

    @Transactional(rollbackFor = Exception.class, readOnly = true)
    public List<Man> findAll(){
        return manRepository.findAll();
    }
}
