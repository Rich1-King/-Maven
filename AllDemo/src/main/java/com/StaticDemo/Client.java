package com.StaticDemo;

/**
 * Created by sunchong on 2016/11/11.
 */
public class Client{

    public static void main(String[] args){
        StaticData.init();
        System.out.println(StaticData.getCount());
        System.out.println("第一次输入结束");
        StaticData staticData = new StaticData();
        staticData.setSum(5);
        staticData.init();
        System.out.println("count:"+StaticData.getCount()+",sum:"+staticData.getSum());
    }
}
