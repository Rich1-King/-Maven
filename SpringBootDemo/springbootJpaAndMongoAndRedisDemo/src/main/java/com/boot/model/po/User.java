package com.boot.model.po;

import javax.persistence.*;

/**
 * Created by rich1 on 11/5/16.
 */
@Entity
@Table(name="user")
public class User{

    public User(){}

    public User(String id, String phone, String password){
        this.id = id;
        this.phone = phone;
        this.password = password;
    }

    @Id
    @Column(name="id")
    private String id;

    @Column(name="phone")
    private String phone;

    @Column(name="password")
    private String password;

    //@ManyToOne(cascade = CascadeType.REFRESH)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Role getRole(){
        return role;
    }

    public void setRole(Role role){
        this.role = role;
    }

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }
}
