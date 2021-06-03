package com.反射;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

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
public class Constructors {
    public static void main(String[] args) {
        try {
            //Class对象
            Class clazz=Class.forName("com.反射.Students");
//            Class<Students> clazz = Students.class;
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
            //调用非空参构造器
            obj=constructor1.newInstance("李小龙");
            System.out.println(obj);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    /*
    * 获取运行时的带泛型的父类的泛型
    * */
    @Test
    public void test2() throws ClassNotFoundException {

        Class clazz=Class.forName("com.反射.Students");
        //获取运行时的带泛型的父类
        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType parameterizedType= (ParameterizedType) genericSuperclass;
        //获取泛型类型
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
//        System.out.println(actualTypeArguments[0].getTypeName());
        System.out.println(((Class) actualTypeArguments[0]).getName());
        System.out.println(genericSuperclass);
    }

    /*
    * 获取运行时类实现的接口
    * */
    @Test
    public void test3() throws ClassNotFoundException {
        Class clazz=Class.forName("com.反射.Students");

//        获取运行时类的接口
        Class[] interfaces = clazz.getInterfaces();
        for (Class c:interfaces
             ) {
            System.out.println(c);
        }
//        获取运行时类父类的接口
        Class[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for (Class c:interfaces1
        ) {
            System.out.println(c);
        }
    }
//        获取运行时类所在的包
    @Test
    public void test4() throws ClassNotFoundException {
        Class clazz=Class.forName("com.反射.Students");

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
//        获取运行时类的注解
        Annotation[] anno = clazz.getAnnotations();
        System.out.println(anno.toString());
    }


}
