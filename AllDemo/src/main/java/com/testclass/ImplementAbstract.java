package com.testclass;

/**
 * Created by rich1 on 5/7/17.
 */
public class ImplementAbstract extends TestAbstractClass{
    @Override
    public void sayAbstract(){
        System.out.println("father abstract");
    }

    @Override
    protected void sayProductAbstract(){
        System.out.println("father product abstract");
    }
}
