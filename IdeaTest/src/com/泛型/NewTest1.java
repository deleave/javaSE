package com.泛型;

import com.反射.Students;
import com.泛型.生成器.BasicGenerator;
import com.泛型.生成器.Generator;

import java.util.*;
class Teacher extends Students{}
public class NewTest1 {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<Teacher> te=Teacher.class;
        Class<? super Teacher > st=te.getSuperclass();
        //st.newInstance()创建的实例类型是Object 因为st是 ”某个类，它是Teacher类的超类“的引用 是非具体的类
        Object obj=st.newInstance();
        //Class<Students> st=te.getSuperClass(); 不能编译
        LinkedList<Students> students=New.lList();
        //生成器添加对象
//        Generator<Students> students;
//        students= BasicGenerator.creat(Students.class);
//        for(int i=0;i<5;i++)
//            students.next();
        System.out.println(students);
    }
}
