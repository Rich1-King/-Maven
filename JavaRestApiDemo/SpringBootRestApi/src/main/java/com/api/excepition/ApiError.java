package com.api.excepition;

/**
 * Created by sunchong on 2017/2/20.
 */
public enum ApiError{

    ;

    ApiError(){}
    ApiError(String codeDescription){
        this.codeDescription = codeDescription;
    }

    private String codeDescription;

    public String getCodeDescription(){
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription){
        this.codeDescription = codeDescription;
    }
}
