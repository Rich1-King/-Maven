package com.copyValueDemo;

/**
 * Created by sunchong on 2017/1/21.
 */

/**
 * java中值相同的基本类型 所指向的内存空间是一样的 值改变重新分配空间
 */
public class Client{
    public static void main(String[] args){
        int a = 10;
        int b = a;
        System.out.println("a hashCode:"+System.identityHashCode(a));
        System.out.println("a value:"+a);
        System.out.println("b hashCode:"+System.identityHashCode(b));
        System.out.println("b value:"+b);
        b++;
        System.out.println("a hashCode:"+System.identityHashCode(a));
        System.out.println("a value:"+a);
        System.out.println("b hashCode:"+System.identityHashCode(b));
        System.out.println("b value:"+b);
    }
}
