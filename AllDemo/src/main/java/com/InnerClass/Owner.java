package com.InnerClass;

/**
 * Created by sunchong on 2016/11/7.
 */
public class Owner{

    private String name;
    private final String sex;

    public Owner(){
        sex = "Man";
    }

    public Owner(String name, String sex){
        this.name = name;
        this.sex = sex;
    }

    class belong{

        private String belonger;

        public String getBelonger(){
            return belonger;
        }

        public void setBelonger(String belonger){
            this.belonger = belonger;
        }

        public void show(){
            System.out.println("belong,name:"+name);
            System.out.println("belong,sex:"+sex);
            name = name +"belong";
            System.out.println("belonger:"+belonger);

        }

    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void showDetail(){
        System.out.println("owner,name:"+name);
    }
}
