package com.authentication;

/**
 * Created by sunchong on 2016/11/9.
 */
public class Authentication<T>{
    private String token;
    private long signTime;
    private T data;
    private Authentication authentication;
    private AuthType authType;

    public String getToken(){
        return token;
    }

    public void setToken(String token){
        this.token = token;
    }

    public long getSignTime(){
        return signTime;
    }

    public void setSignTime(long signTime){
        this.signTime = signTime;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public Authentication getAuthentication(){
        return authentication;
    }

    public void setAuthentication(Authentication authentication){
        this.authentication = authentication;
    }

    public AuthType getAuthType(){
        return authType;
    }

    public void setAuthType(AuthType authType){
        this.authType = authType;
    }

    public enum AuthType{
        MANY,
        ONE
    }

}
