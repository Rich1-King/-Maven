package com.boot.model.po;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by rich1 on 11/5/16.
 */
@Entity
@Table(name = "role")
public class Role{

    public Role(){}

    public Role(String id, String name){
        this.id = id;
        this.name = name;
    }

    @Id
    @Column(name = "id")
    private String id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role", cascade = CascadeType.REFRESH,fetch =
            FetchType.EAGER)
    private Set<User> users;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<User> getUsers(){
        return users;
    }

    public void setUsers(Set<User> users){
        this.users = users;
    }
}
