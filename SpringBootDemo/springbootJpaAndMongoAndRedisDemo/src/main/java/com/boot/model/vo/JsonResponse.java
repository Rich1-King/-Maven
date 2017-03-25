package com.boot.model.vo;

/**
 * Created by rich1 on 12/20/16.
 */
public class JsonResponse<T>{

    private boolean flag = true;
    private T data;

    public JsonResponse(){}

    public JsonResponse(T data){
        this.data = data;
    }


    public boolean isFlag(){
        return flag;
    }

    public void setFlag(boolean flag){
        this.flag = flag;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}
