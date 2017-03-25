package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rich1 on 9/20/16.
 */
@Service
@Transactional
public class UserService{

    @Autowired
    UserRepository userRepository;

    public void insertUser(User human){
        userRepository.save(human);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public void deleteUser(User human){
        userRepository.delete(human);
    }

    public void updateUser(User human){
        userRepository.saveAndFlush(human);
    }
}
