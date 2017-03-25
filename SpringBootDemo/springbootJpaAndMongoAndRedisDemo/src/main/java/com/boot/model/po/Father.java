package com.boot.model.po;

import javax.persistence.*;
import java.util.List;

/**
 * Created by rich1 on 9/11/16.
 */
@Entity
@Table(name="father")
public class Father{

    @Id
    private String fid;
    private String name;
    private int age;

   // @OneToMany
    //@JoinColumn(name = "fid")
    @Transient
    private List<Son> sons;

    public String getFid(){
        return fid;
    }

    public void setFid(String fid){
        this.fid = fid;
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

    public List<Son> getSons(){
        return sons;
    }

    public void setSons(List<Son> sons){
        this.sons = sons;
    }
}
