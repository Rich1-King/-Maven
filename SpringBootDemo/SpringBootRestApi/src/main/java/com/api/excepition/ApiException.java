package com.api.excepition;

/**
 * Created by sunchong on 2017/2/20.
 */
public class ApiException extends Exception{

    private ApiError error;

    public ApiException(){
    }

    public ApiException(ApiError error){
        this.error = error;
    }


    public ApiError getApiError(){
        return error;
    }

    public void setApiError(ApiError error){
        this.error = error;
    }
}
