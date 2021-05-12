package com.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
/*
 * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 * 		1).批量的方法：
 * 			public Constructor[] getConstructors()：所有"公有的"构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

 * 		2).获取单个的方法，并调用：
 * 			public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 * 			public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 * 			调用构造方法：
 * 			Constructor-->newInstance(Object... initargs)
 */
public class Constructors{
    public static void main(String[] args) {
        try {
            //Class对象
            Class clazz=Class.forName("com.反射.Students");
            System.out.println("**********************所有公有构造方法*********************************");
            Constructor[] conArray1=clazz.getConstructors();
            for (Constructor c:conArray1) {
                System.out.println(c);
            }
            System.out.println("**********************所有构造方法*********************************");
            Constructor[] conArray2=clazz.getDeclaredConstructors();
            for (Constructor con: conArray2
                 ) {
                System.out.println(con);
            }
            System.out.println("**********************获取公共无参构造方法*********************************");
            Constructor constructor=clazz.getConstructor();
            System.out.println("constructor "+constructor);
            Object obj=constructor.newInstance();
            System.out.println("**********************获取私有有参构造方法*********************************");
            Constructor constructor1=clazz.getDeclaredConstructor(String.class);
            System.out.println("constructor1 "+constructor1);
            //暴力访问 无视访问修饰符
            constructor1.setAccessible(true);
            obj=constructor1.newInstance("李小龙");
            //System.out.println(obj);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

}
