package com.systemDemo;

import java.util.Iterator;

/**
 * Created by rich1 on 12/24/16.
 */
public class SystemInformationDemo{
    public static void main(String[] args){
        getInformation();
    }

    public static void getInformation(){
        Iterator iterator = System.getenv().keySet().iterator();
        Iterator iterator1 = System.getenv().values().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString() + ":" + iterator1.next());
        }
    }
}
