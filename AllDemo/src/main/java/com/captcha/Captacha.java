package com.captcha;

/**
 * Created by sunchong on 2016/11/7.
 */
public class Captacha{


    private String code;
    private String base64Image;


    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getBase64Image(){
        return base64Image;
    }

    public void setBase64Image(String base64Image){
        this.base64Image = base64Image;
    }
}
