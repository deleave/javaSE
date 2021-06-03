package com.反射;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

/*
 * 获取成员变量并调用：
 *
 * 1.批量的
 * 		1).Field[] getFields():获取所有的"公有字段"
 * 		2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 * 2.获取单个的：
 * 		1).public Field getField(String fieldName):获取某个"公有的"字段；
 * 		2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 * 	 设置字段的值：
 * 		Field --> public void set(Object obj,Object value):
 * 					参数说明：
 * 					1.obj:要设置的字段所在的对象；
 * 					2.value:要为字段设置的值；
 *
 */
public class Fields {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class clazz = Class.forName("com.反射.Students");
        System.out.println("************获取所有公有的字段********************");
        Field[] f1 = clazz.getFields();
        for (Field f : f1
        ) {
            System.out.println(f);
        }
        System.out.println("************获取所有的字段********************");
        Field[] f2 = clazz.getDeclaredFields();
        for (Field f : f2
        ) {
            System.out.println(f);
        }

        System.out.println("************获取公有的字段********************");
        Field field = clazz.getField("phoneNum");

        //调用Class类对象指向的类的公共无参构造器 同时创建一个目标对象
        Object obj = clazz.getConstructor().newInstance();
        Students stu=(Students) obj;
        field.set(obj, "1399752411");

        System.out.println("电话"+field.get(stu));

        System.out.println("************获取的保护字段********************");
        Field field1=clazz.getDeclaredField("age");

        // Object obj1=clazz.getDeclaredConstructor().newInstance();
        field1.set(obj,19);
        System.out.println("年龄:"+field1.get(stu));

        System.out.println("************获取的包内字段********************");
        Field field2=clazz.getDeclaredField("sex");
        field2.set(obj,'m');
        System.out.println("性别:"+field2.get(stu));

        System.out.println("************获取私有的字段********************");
        Field field3=clazz.getDeclaredField("name");
        System.out.println(field3);
        //无视访问修饰符访问
        field3.setAccessible(true);
        field3.set(obj,"俞嘉川");
        System.out.println(stu.toString());

    }
    @Test
    public void test() throws Exception {
        Class clazz = Class.forName("com.反射.Students");
        Field[] fields = clazz.getDeclaredFields();
        for (Field f:fields
             ) {
//            1.获取访问权限修饰符
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.toString(modifiers)+"\t");

            //2.获取属性类型
            System.out.println(f.getType());
            //3.获取属性名
            System.out.println(f.getName());
        }

    }
}