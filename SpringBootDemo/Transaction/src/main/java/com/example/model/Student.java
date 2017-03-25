package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rich1 on 9/20/16.
 */
@Entity(name="student")
@Table(name="student")
public class Student{

    @Id
    private String sid;
    private String name;

    public String getSid(){
        return sid;
    }

    public void setSid(String sid){
        this.sid = sid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
