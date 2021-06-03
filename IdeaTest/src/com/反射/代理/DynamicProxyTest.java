package com.反射.代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxyTest
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/19 20:32
 * @Version 1.0
 **/
interface Human{
    String getBelief();
    void eat(String food);
}
//被代理类
class SuperMan implements Human{

    private Human man;
    @Override
    public String getBelief() {
        return "I believe my belief";
    }

    @Override
    public void eat(String food) {
        System.out.println("我想吃"+food);
    }
}

class NormalMan implements Human{

    @Override
    public String getBelief() {
        return "I believe money ";
    }

    @Override
    public void eat(String food) {
        System.out.println("我想吃"+food);
    }
}

class HumanUtil{

    public void method1(){
        System.out.println("==============通用代码1==============");
    }
    public void method2(){
        System.out.println("==============通用代码2==============");
    }
}
/*
* 要想实现动态代理要解决的问题
* 1.如何根据加载到内存的得代理类,动态的创建代理类及其对象
* 2.如何通过代理类的对象调用方法时,如何动态的去调用被代理类中的同名方法
* */

class ProxyFactory{
    //调用此方法:返回一个代理类的对象
    public  static  Object getProxyInstance(Object obj){
        //handler 对象会自动调用自己的invoke()方法,
        // 在invoke()方法内调用代理类的方法的同时增强原始被代理类的方法的逻辑功能

        MyInvocationHandler handler = new MyInvocationHandler(obj);


        //obj:被代理对象

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),handler);
    }
}


class MyInvocationHandler implements InvocationHandler{


    private Object obj;//赋值时,也要使用被代理类的对象赋值

    //利用有参构造函数来传入被代理对象
    public MyInvocationHandler(Object obj){
        this.obj=obj;
    }
    //当我们通过代理类的对象,来调用方法a时,就会自动调用如下的方法:invoke()
    //将被代理类要指向的方法a的功能声明在invoke()中
    //invoke参数
    //proxy - 调用该方法的代理实例
    //method -所述方法对应于调用代理实例上的接口方法的实例
    //args -包含的方法调用传递代理实例的参数值的对象的阵列，或null如果接口方法没有参数。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();
        //method:代理类调用的方法,此方法也就作为了被代理类对象调用的方法
       //obj:被代理的对象
        // 代理类利用反射来调用原始被代理类的同名方法
        Object returnVal = method.invoke(obj, args);

        util.method2();
        //上述方法的返回值就作为当前类中invoke()的返回值
        return returnVal;
    }
}
public class DynamicProxyTest {
    public static void God(Human itf,String food){
        String belief = itf.getBelief();
        itf.eat(food);
        System.out.println(belief);
    }
    public static void main(String[] args) {
        //被代理对象
        SuperMan superMan = new SuperMan();

        NormalMan normalMan = new NormalMan();
        //代理类的对象(获得了代理类实现的接口,所以可以强转)
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        Human proxyInstance1 = (Human) ProxyFactory.getProxyInstance(normalMan);

        //当通过代理类对象调用方法时,会自动的调用被代理类中的同名方法
        // (多态里:基类的变量(Human接口变量引用了派生类SuperMan的实例方法) -->由实例的不同动态的引用了不同类重写的同名的方法)

        God(proxyInstance,"辣的");
        God(proxyInstance1,"香的");

        AntaClothFactory anta = new AntaClothFactory();
        ClothFactory proxyInstance2 = (ClothFactory) ProxyFactory.getProxyInstance(anta);
        proxyInstance2.produceCloth();
    }
}
