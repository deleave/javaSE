package com.字符串;

import sun.java2d.pipe.SpanShapeRenderer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner=new Scanner(System.in);
//        System.out.println("What's your name?");
//        String name=scanner.nextLine();
//        System.out.println("My name is "+name);
        System.out.println("Please write the Student manage");
        Student s1=new Student("Davies 18 1234 79.5 553");
        System.out.println(s1);
    }
}
class Student{
    private String name;
    private int age;
    private long number;
    private float score;
    private double sumOfscore;
    public Student(String s){
        Scanner sc=new Scanner(System.in);
        this.name=sc.nextLine();
        this.age=sc.nextInt();
        this.number=sc.nextLong();
        this.score=sc.nextFloat();
        this.sumOfscore=sc.nextDouble();
    }
    public String toString(){
        return "name:"+name+": age"+age+"sumOfscore "+sumOfscore;
    }
}
