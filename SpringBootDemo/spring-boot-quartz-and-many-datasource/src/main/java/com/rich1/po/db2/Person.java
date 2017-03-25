package com.rich1.po.db2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sunchong on 2016/12/8.
 */
@Entity
@Table(name = "person")
public class Person{
    @Id
    private String pId;
    private String pName;
    private String pAge;

    public String getpAge(){
        return pAge;
    }

    public void setpAge(String pAge){
        this.pAge = pAge;
    }

    public String getpName(){
        return pName;
    }

    public void setpName(String pName){
        this.pName = pName;
    }

    public String getpId(){
        return pId;
    }

    public void setpId(String pId){
        this.pId = pId;
    }
}
