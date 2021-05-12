package com.反射.代理;
//代理：为了提供额外的或不同的操作，而插入的用来代替”实际“对象的对象
//SimpleProxy实例对象就是代替RealObject"实际"对象的对象，并且提供了额外的操作
interface  Interface{
    void doSomething();
    void somethingElse(String arg);
}
class RealObject implements Interface{
    private static long counter=0;
    private final long id=counter++;
    public void doSomething(){
        System.out.println("doSomething "+id);
    }
    public void somethingElse(String arg){
        System.out.println("somethingElse "+arg+" "+id);
    }
}
class SimpleProxy implements Interface{

    private Interface proxied;//私有接口变量
    //接口变量通过构造器赋值
    public   SimpleProxy(Interface proxied){
        this.proxied=proxied;
    }
    public void doSomething(){
        //额外操作
        System.out.println("SimpleProxy doSomething");
        proxied.doSomething();//接口变量调用方法
    }
    public void somethingElse(String arg){
        //额外操作
        System.out.println("SimpleProxy something "+arg);
        proxied.somethingElse(arg);//接口变量调用方法
    }
}
public class SimpleProxyDemo {
    //公共调用主程序 接口多态
    public static void consumer(Interface iface){
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        consumer(new RealObject());
        consumer(new SimpleProxy(new RealObject()));
    }
}
