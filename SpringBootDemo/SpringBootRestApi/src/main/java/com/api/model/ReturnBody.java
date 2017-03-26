package com.api.model;

import com.api.excepition.ApiError;

/**
 * Created by sunchong on 2017/2/20.
 */
public class ReturnBody<T>{

    private String code;
    private String codeDescription;
    private T data;

    public ReturnBody(){}

    public ReturnBody(T data){
        this.code = "SUCCESS";
        this.data = data;
        this.codeDescription = "调用成功";
    }

    public static ReturnBody createError(ApiError apiError){
        ReturnBody returnBody = new ReturnBody();
        returnBody.setCode(apiError.name());
        returnBody.setCodeDescription(apiError.getCodeDescription());
        returnBody.setData(null);
        return returnBody;
    }

    public String getCodeDescription(){
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription){
        this.codeDescription = codeDescription;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }
}
