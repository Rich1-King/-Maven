package com.testclass;

/**
 * Created by rich1 on 5/7/17.
 */
//抽象类不可以实例化，因为其中存在这未实现的方法
public abstract class TestAbstractClass{

    public TestAbstractClass(){}

    public void sayHello(){
        System.out.println("hello");
    }

    public abstract void sayAbstract();

    //producted同一个架包，父类中使可以使用的
    protected abstract void sayProductAbstract();

}
