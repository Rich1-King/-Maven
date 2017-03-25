package com.boot.model.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * Created by rich1 on 9/9/16.
 */
@Entity
@Table(name="person")
public class Person implements Serializable{

    @Id
    private String id;
    private String name;
    private int age;

    //短暂的,不会实例化，即会保存到数据库，也不会保存起来,对数据库不造成影响
    @Transient
    private String value;

    public Person(){}

    public Person(String id, String name, int age){
        setId(id);
        setName(name);
        setAge(age);
    }

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

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getValue(){
        return value;
    }

    public void setValue(String value){
        this.value = value;
    }
}
