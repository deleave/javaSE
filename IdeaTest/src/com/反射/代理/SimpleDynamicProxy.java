package com.反射.代理;

import java.lang.reflect.*;

//newProxyInstance()方法 创建代理类
// public static Object newProxyInstance(ClassLoader loader,Class<?>[] interfaces, InvocationHandler h)

//InvocationHandler接口实现方法
//Object  invoke(Object proxy,   Method m,    Object[] args)
//Object：被代理的类的实例，本例中，将会是RealObject类的实例
//        Method：被代理的类实例的方法
//        Object[]：上面那个Method的参数

//动态代理
class DynamicProxyHandler implements InvocationHandler{
    private Object proxied;
    public DynamicProxyHandler(Object proxied){
        this.proxied=proxied;
    }
    public Object invoke(Object proxy,Method method,Object[] args)throws Throwable{
        //代理后额外操作
        System.out.println(" ****proxy: "+proxy.getClass().getClassLoader()+", method: "+method+
                ", args: "+args);
        if (args!=null){
            for (Object arg:args
                 ) {
                System.out.println("  "+arg);
            }
        }
        //Jvm通过这条语句来执行原先的代码（反射机制）
        return method.invoke(proxied,args);
    }
}

public class SimpleDynamicProxy {
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real=new RealObject();
        consumer(real);
        //插入代理后
        Interface proxy=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),
                new Class[]{Interface.class},new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
