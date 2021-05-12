package com.反射;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/*
 * 获取成员方法并调用：
 *
 * 1.批量的：
 * 		public Method[] getMethods():获取所有"公有方法"；（包含了父类的方法也包含Object类）
 * 		public Method[] getDeclaredMethods():获取所有的成员方法，包括私有的(不包括继承的)
 * 2.获取单个的：
 * 		public Method getMethod(String name,Class<?>... parameterTypes):
 * 					参数：
 * 						name : 方法名；
 * 						Class ... : 形参的Class类型对象
 * 		public Method getDeclaredMethod(String name,Class<?>... parameterTypes)
 *
 * 	 调用方法：
 * 		Method --> public Object invoke(Object obj,Object... args):
 * 					参数说明：
 * 					obj : 要调用方法的对象；
 * 					args:调用方式时所传递的实参；
):
 */
public class Methods {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //创建一个反射对象
        Class clazz=Class.forName("com.反射.Students");
        System.out.println("***************获取所有的”公有“方法*******************");
        Method[] methods=clazz.getMethods();
        for (Method m:methods
             ) {
            System.out.println(m);
        }
        System.out.println("***************获取所有的方法*******************");
        Method[] methods1=clazz.getDeclaredMethods();
        for (Method m:methods1
             ) {
            System.out.println(m);
        }
        System.out.println("***************获取公有的方法*******************");
        Method method=clazz.getMethod("show1", String.class);
        System.out.println(method);
        //实例化一个对象
        Object obj=clazz.getConstructor().newInstance();
        method.invoke(obj,"李小龙");
        System.out.println("***************获取私有的方法*******************");
        Method method1=clazz.getDeclaredMethod("show4", int.class);
        System.out.println(method1);
        method1.setAccessible(true);
        method1.invoke(obj,20);
        Students stu=(Students) obj;
        System.out.println(stu);
    }
}
