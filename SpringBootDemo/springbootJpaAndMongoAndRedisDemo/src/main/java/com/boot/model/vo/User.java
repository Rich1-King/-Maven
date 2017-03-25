package com.boot.model.vo;

import java.io.Serializable;

/**
 * Created by rich1 on 9/10/16.
 */
public class User implements Serializable{

    private String username;
    private int age;

    public User(String username, int age){
        setUsername(username);
        setAge(age);
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}
