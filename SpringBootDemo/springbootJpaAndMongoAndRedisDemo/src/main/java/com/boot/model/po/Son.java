package com.boot.model.po;

import javax.persistence.*;

/**
 * Created by rich1 on 9/11/16.
 */
@Entity
@Table(name="son")
public class Son{

    public Son(){}

    @Id
    private String sid;

    private String name;
    private int age;
    private String fid;

    /*@ManyToOne
    @JoinColumn(name = "fid")
    private Father father;*/

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

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getFid(){
        return fid;
    }

    public void setFid(String fid){
        this.fid = fid;
    }

   /* public Father getFather(){
        return father;
    }

    public void setFather(Father father){
        this.father = father;
    }*/

}
