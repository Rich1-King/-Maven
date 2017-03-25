package com.content.model.po;

import javax.persistence.*;

/**
 * Created by rich1 on 10/16/16.
 */
@Entity
@Table(name="user")
public class User{

    @Enumerated(EnumType.STRING)
    private ROLE role;

    public enum ROLE{
        admin,
        user
    }

    @Id
    private String username;

    private String password;

    public ROLE getRole(){
        return role;
    }

    public void setRole(ROLE role){
        this.role = role;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
