package com.rich1.po.db2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sunchong on 2016/12/8.
 */
@Entity
@Table(name = "man")
public class Man{
    @Id
    private String mId;
    private String mName;
    private String mSex;
    private String personId;
    private Integer mage;

    public String getmName(){
        return mName;
    }

    public void setmName(String mName){
        this.mName = mName;
    }

    public String getmSex(){
        return mSex;
    }

    public void setmSex(String mSex){
        this.mSex = mSex;
    }

    public String getPersonId(){
        return personId;
    }

    public void setPersonId(String personId){
        this.personId = personId;
    }

    public String getmId(){
        return mId;
    }

    public void setmId(String mId){
        this.mId = mId;
    }

    public Integer getMage(){
        return mage;
    }

    public void setMage(Integer mage){
        this.mage = mage;
    }
}
