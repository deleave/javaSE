package com.反射;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
//       获取指定方法show1()
        Method method=clazz.getMethod("show1", String.class);
        System.out.println(method);
        //实例化一个对象
        Students obj= (Students) clazz.getConstructor().newInstance();
        //invoke 参数1 方法调用的对象 参数2 指明获取的方法的形参列表
//        invoke ()方法的返回值即为对应类中调用的方法的返回值
        method.invoke(obj,"李小龙");

        System.out.println("***************获取私有的方法*******************");
        Method method1=clazz.getDeclaredMethod("show4", int.class);
        System.out.println(method1);
        //保证方法是可访问的
        method1.setAccessible(true);
        Students invoke = (Students) method1.invoke(obj, 20);
       //show4() 方法中 return this.toString()
        // 所以会打印出对象
        System.out.println(invoke);

        System.out.println("*************调用静态方法**********");
        //    private static void showStatic()
        Method showStatic = clazz.getDeclaredMethod("showStatic");
        showStatic.setAccessible(true);
        Object returnVal = showStatic.invoke(Students.class);
       //若无返回值invoke返回null
        System.out.println(returnVal);//null

    }
    /*
    * @Xxx
    * 前线修饰符 返回值类型 方法名(参数类型 形参名) trowXxxException{}
    * */
    @Test
    public void test() throws ClassNotFoundException {

//        1.获取注解
        Class clazz=Class.forName("com.反射.Students");
        Method[] methods=clazz.getDeclaredMethods();
        for (Method m:methods
        ) {
            //        1.获取注解
            Annotation[] anno = m.getAnnotations();
            for (Annotation a:anno
                 ) {
                System.out.println(a);
            }

//            2.获取权限修饰符
            System.out.println(Modifier.toString(m.getModifiers()) + "\t");

//            3.返回值类型
            System.out.println(m.getReturnType().getName() + "\t");

//            4.方法名
            System.out.println(m.getName());

            System.out.println("(");
            Class<?>[] parameterTypes = m.getParameterTypes();
            if (!(parameterTypes==null&&parameterTypes.length==0)){
                for (Class p:parameterTypes
                     ) {
                    for (int i=0;i<parameterTypes.length;i++){
                        System.out.println(p.getName() + ":args" + i);
                    }
                }
            }
            System.out.println(")");

//            5.获取异常
            Class<?>[] exceptionTypes = m.getExceptionTypes();
            if (!(exceptionTypes==null&&exceptionTypes.length==0)){
                System.out.println("throws");
                for (int i=0;i<exceptionTypes.length;i++){
                    if (i==exceptionTypes.length-1){
                        System.out.println(exceptionTypes[i].getName() );
                        break;
                    }
                    System.out.println(exceptionTypes[i].getName() + ",");

                }
            }
        }
    }
}
