package com.testclass;

/**
 * Created by rich1 on 5/7/17.
 */
public class Client{

    public static void main(String[] args){
        ImplementAbstract implementAbstract = new ImplementAbstract();
        implementAbstract.sayAbstract();
        implementAbstract.sayHello();
        implementAbstract.sayProductAbstract();

        TestInterface testInterface = new TestInterface(){
            @Override
            public void sayInterface(){
                System.out.println("say interface");
            }
        };

        testInterface.sayInterface();
    }
}
