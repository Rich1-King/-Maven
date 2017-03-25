package com.StaticDemo;

/**
 * Created by sunchong on 2016/11/11.
 */
public class StaticData{

    private static int count = 0;
    private int sum;

    static{
        System.out.println("This is static.....,this is only execute one time");
    }

    public static void init(){
        System.out.println("开始初始化.....");
        count++;
    }

    public static int getCount(){
        return count;
    }

    public static void setCount(int count){
        StaticData.count = count;
    }

    public int getSum(){
        return sum;
    }

    public void setSum(int sum){
        this.sum = sum;
    }
}
