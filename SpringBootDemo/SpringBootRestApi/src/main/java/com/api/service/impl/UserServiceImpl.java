package com.api.service.impl;

import com.api.model.po.User;
import com.api.repository.UserRepository;
import com.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by sunchong on 2017/2/21.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public void saveUser(User user){
        user.setId(UUID.randomUUID().toString().replaceAll("-", ""));
       try{
           userRepository.save(user);
       }catch (Exception e){
           userRepository.createTable();
       }
    }

    @Override
    public void createUserTable(){
        userRepository.createTable();
    }
}
