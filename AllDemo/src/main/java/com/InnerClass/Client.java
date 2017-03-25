package com.InnerClass;

/**
 * Created by sunchong on 2016/11/7.
 */
public class Client{

    public static void main(String[] args){
        Owner owner = new Owner();
        owner.setName("zhangsan");
        Owner.belong belong = owner.new belong();
        belong.show();
        owner.showDetail();

    }
}
