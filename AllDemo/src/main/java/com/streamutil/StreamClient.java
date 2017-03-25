package com.streamutil;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by sunchong on 2017/3/7.
 */
public class StreamClient{

    public static void main(String[] args){
//        streamStringFilter();
//        sortObjPropertyFilter();
//        getObjePropertyFilter();
//        streamObjPropertyFilter();
//        getObj2ObjFilter();
   //     Calendar calendar = Calendar.getInstance();
     //   System.out.println(calendar.getMaximum(Calendar.DAY_OF_MONTH));
        mapToString();
    }

    /**
     * 过滤集合字符串大于一定值
     * @param
     * @return
     */
    public static void streamStringFilter(){
        List<String> strList = new ArrayList<>();
        strList.add("111");
        strList.add("22");
        strList.add("aaaaa");
        strList = strList.stream().filter(s1 -> s1.length() > 2).collect(Collectors.toList());
        for(String str : strList){
            System.out.println(str);
        }
    }

    public static void streamObjPropertyFilter(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 10));
        studentList.add(new Student("lier", 30));
        studentList.add(new Student("wangwu", 40));
        studentList.add(new Student("lisi", 25));
        List<Student> sList = studentList.stream().filter((s) -> {
            if (s.getAge() > 25)
                return true;
            return false;
        }).collect(Collectors.toList());
        for(Student student:sList){
            System.out.println("name=>"+student.getName()+",age=>"+student.getAge());
        }
    }

    public static void sortObjPropertyFilter(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 10));
        studentList.add(new Student("lier", 30));
        studentList.add(new Student("wangwu", 40));
        studentList.add(new Student("lisi", 25));
        List<Student> sList = studentList.stream().sorted(Comparator.comparingInt(Student::getAge)).collect(Collectors.toList());
//        List<Student> sList = studentList.stream().sorted((s1,s2) -> {
//            return s1.getAge().compareTo(s2.getAge());
//        }).collect(Collectors.toList());
        for(Student student:sList){
            System.out.println("name=>"+student.getName()+",age=>"+student.getAge());
        }
    }

    public static void getObjePropertyFilter(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("zhangsan", 10));
        studentList.add(new Student("lier", 30));
        studentList.add(new Student("wangwu", 40));
        studentList.add(new Student("lisi", 25));
        List<Integer> sAges = studentList.stream().map(Student::getAge).collect(Collectors.toList());
        for(Integer sAge:sAges){
            System.out.println("age=>"+sAge);
        }
    }

    public static void getObj2ObjFilter(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("s0001","zhangsan", 10));
        studentList.add(new Student("s0002","lier", 30));
        studentList.add(new Student("s0003","wangwu", 40));
        studentList.add(new Student("s0004","lisi", 25));
        List<Person> pList = studentList.stream().map((s)->{
            Person p = new Person();
            p.setAge(s.getAge());
            p.setName(s.getName());
            return p;
        }).collect(Collectors.toList());
        for(Person p : pList){
            System.out.println(String.format("person====>p.name:%s, p.age:%s", p.getName(), p.getAge()));
        }
    }

    public static void mapToParam(){
        List<String> accountList = new ArrayList<>();
        accountList.add("a1");
        accountList.add("a2");
        accountList.add("a3");
        String accountStr = "";
        Map map = new HashMap();
        int num = accountList.stream().mapToInt((account)->{
//            accountStr = accountStr + "," + account;
            map.put("a",account);
            return 1;
        }).sum();
    }

    public static void mapToString(){
        List<Person> persons = new ArrayList<>();
        Person person = new Person();
        person.setAge(1);
        person.setName("123");
        persons.add(person);
        Person person1 = new Person();
        person1.setAge(2);
        person1.setName("234");
        persons.add(person1);
        Person person2 = new Person();
        person2.setAge(3);
        person2.setName("lier");
        persons.add(person2);
        List<String> nameList = persons.stream().filter(p->{
            return p.getAge() > 1;
        }).map(p->p.getName()).collect(Collectors.toList());
        nameList.stream().forEach(n->{
            System.out.println(n);
        });
    }

}
