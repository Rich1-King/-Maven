package com.api.service;

import com.api.model.po.User;

/**
 * Created by sunchong on 2017/2/21.
 */
public interface UserService{

    void saveUser(User user);

    void createUserTable();

}
