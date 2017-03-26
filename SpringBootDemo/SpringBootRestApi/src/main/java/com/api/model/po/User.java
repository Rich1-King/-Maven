package com.api.model.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by sunchong on 2017/2/21.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    private String id;
    private String name;
    private Integer age;
    private String sex;

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

    public Integer getAge(){
        return age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
}
