package com.authentication;

/**
 * Created by sunchong on 2016/11/10.
 */
public class AuthData{
    public int getAuth(){
        return auth;
    }

    public void setAuth(int auth){
        this.auth = auth;
    }

    public String getStr(){
        return str;
    }

    public void setStr(String str){
        this.str = str;
    }

    private int auth;
    private String str;
}
