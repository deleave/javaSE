package com.反射;

public class Students {
    public String phoneNum;
    protected int age;
    char sex;
    private String name;
    public Students(){
        System.out.println("公有无参构造器");
    }
    protected Students(int age){
        this.age=age;
        System.out.println("保护有参构造器");
    }
    Students(char sex){
        this.sex=sex;
        System.out.println("包内有参构造器");
    }
    private Students(String name){
        this.name=name;
        System.out.println("私有有参构造器");
    }
    public Students(String name,int age){
        this.name=name;
        this.age=age;
        System.out.println("公有多参数构造器");
    }
    public String show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
        this.name=s;
        return toString();
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        this.age=age;
        return toString();
    }
    public String toString(){
        return "phoneNum:"+phoneNum+" "+"age:"+age+" "
                +"sex:"+sex+" "+"name:"+name;
    }
}
