package com.接口;

//方法接口
interface Service{
    void method1();
    void method2();
}
interface EB{}
interface B{}
class C implements B{
    EB makeEB(){
        return new EB() {
        };
    }
}
//加工接口,获得服务
interface ServiceFactory{
    Service getService();
}
//实现接口
class Implementation1 implements Service{
    Implementation1(){}
    public void method1(){
        System.out.println("Implementation1 method1");
    }
    public void method2(){
        System.out.println("Implementation1 method2");
    }
    // 匿名内部类构造方法
    public static ServiceFactory factory= Implementation1::new;
}
//工厂实现加工接口
class Implementation1Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation1();
    }
}
class Implementation2 implements Service{
    Implementation2(){}//包内方法
    public void method1(){
        System.out.println("Implementation2 method1");
    }
    public void method2(){
        System.out.println("Implementation2 method2");
    }
    //匿名内部类
    public static ServiceFactory factory= new ServiceFactory() {
        @Override
        public Service getService() {
            return new Implementation2();
        }
    };
}
class Implementation2Factory implements ServiceFactory{
    public Service getService(){
        return new Implementation2();
    }
}
public class Factories {
    //公共调用方法
    public static void serviceConsumer(ServiceFactory fact){
        Service s=fact.getService();
        s.method1();
        s.method2();
    }
    public static void main(String[] args) {
        serviceConsumer(new Implementation1Factory());//普通调用
        serviceConsumer(new Implementation2Factory());
        serviceConsumer(Implementation1.factory);//匿名内部类调用
        serviceConsumer(Implementation2.factory);
    }
}
