package com.反射;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/16 18:25
 * @Version 1.0
 **/
public class ReflectionTest {

   //反射之前
    @Test
    public void test1(){
        //1.创建一个实例
        Students s1 = new Students("黄烨",20);

        //通过对象调用其内部方法和字段
        s1.age=19;
        System.out.println(s1.toString());

        s1.show2();
    }

    //反射的方式
/*     * 什么时候用反射new实例?
       * 编译的时候不能确定造哪个对象的时候用反射
         * 关丁java.lang.class类的理解
         *      1.类的加载过程:
            * 程序经过javac.exe命令以后，会生成一个或多个字节码文件(.class结尾)。
            * 接着我们使用java.exe命令对某个字节码文件进行解释运行。
            * 相当于将某个字节码文件加载到内存中。此过程就称为类的加载。
            * 加载到内存中的类，我们就称为运行时类，此运行时类,就作为CLass的一个实例。
            *
            * 2.换句话说，Class的实例就对应着一个运行时类。
            * 3.加载到内存中的运行时类，会缓存一定的时间。
            *   在此时间之内，我们可以通过不同的方式来获取此运行时类。
            *
            * */
    @Test
    public void test2() throws Exception {
        Class clazz = Students.class;

        //1.通过反射创建Students的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object o = cons.newInstance("姜鹏宇", 19);
        Students s1= (Students) o;

        //2.通过反射调用对象的属性和方法
        Field age = clazz.getDeclaredField("age");
        age.set(s1,21);
        System.out.println(s1.toString());

        //调用方法
        Method show1 = clazz.getDeclaredMethod("show1", String.class);
        show1.invoke(s1,"何陈园");

        //通过反射,可以调用私有的字段,方法,构造器
        //调用私有构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Students s2 = (Students) cons1.newInstance("黄一鸣");
        System.out.println(s2.toString());

        //调用私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(s2,"雲");
        System.out.println(s2);

        //调用私有方法
        Method show4 = clazz.getDeclaredMethod("show4", int.class);
        show4.setAccessible(true);
        String Age = (String) show4.invoke(s1, 22);//相当于s1.show4(22)
        System.out.println(Age);
    }

    /*
    *@ClassName ReflectionTest
    *@Description 获取Class类的实例
    *@Author deleave
    *@Date 2021/5/16 19:17
    *@Param []
    **/
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一:调用运行时类的属性:.class
        Class<Students> clazz1 = Students.class;

        //方式二:通过运行时类的对象,
        Students s1 = new Students();
        Class<? extends Students> clazz2 = s1.getClass();
//        System.out.println(clazz2);

        //方式三:
        Class<?> clazz3 = Class.forName("com.反射.Students");
//        System.out.println(clazz3);


//        System.out.println(clazz1 == clazz2);true
//        System.out.println(clazz2 == clazz3);true

        //方式四:使用类的加载器:ClassLoader
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class<?> clazz4 = classLoader.loadClass("com.反射.Students");
        System.out.println(clazz4);
    }
}
