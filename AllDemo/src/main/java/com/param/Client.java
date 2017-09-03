package com.param;

/**
 * Created by rich1 on 8/6/17.
 */
public class Client{

    public static void main(String[] args){
        Person person = new Person();
        person.setAge(5);
        System.out.println(person.getAge());
        changePerson(person);
        System.out.println(person.getAge());
    }

    public static Person changePerson(Person p){
        p.setAge(p.getAge()+10);
        return p;
    }

}
