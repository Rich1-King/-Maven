package com.string;

/**
 * Created by sunchong on 2017/3/23.
 */
public class Replace{

    public static void main(String[] args){
        String str = "(account1:1),(account2:2)";
        String newstr = str.replaceAll("[(|)]","");
        System.out.println(newstr);
    }
}
