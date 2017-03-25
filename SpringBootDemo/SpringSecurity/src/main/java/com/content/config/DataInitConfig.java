package com.content.config;

import com.content.model.po.User;
import com.content.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Created by rich1 on 10/16/16.
 */
@Configuration
public class DataInitConfig{
    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void dataInit(){
        User admin = new User();
        admin.setPassword("admin");
        admin.setUsername("admin");
        admin.setRole(User.ROLE.admin);
        userRepository.save(admin);

        User user = new User();
        user.setPassword("user");
        user.setUsername("user");
        user.setRole(User.ROLE.user);
        userRepository.save(user);
    }
}
