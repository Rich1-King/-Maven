package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by rich1 on 9/20/16.
 */
@Entity
@Table(name="user")
public class User{

    /**
     * 数据库中可以不设置主键，但是我们在建立实体类的时候一定要选中一列当主键.(不过最好在建立数据库表的时候设置主键)
     */

    @Id
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "sex")
    private String sex;

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

    public String getSex(){
        return sex;
    }

    public void setSex(String sex){
        this.sex = sex;
    }
}
