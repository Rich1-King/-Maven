package com.classloader;

/**
 * Created by sunchong on 2017/2/4.
 */

/**
 * 当在加载类的时候,类加载器加载类
 */
public class ClassLoderClient{

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
        TestArrayClass[] testArrayClasses = new TestArrayClass[10];
        testArrayClasses[0] = (TestArrayClass) Class.forName("com.classloader.TestArrayClass").newInstance();
        System.out.println(testArrayClasses[0].toString());
        System.out.println(testArrayClasses.toString());
    }

}
