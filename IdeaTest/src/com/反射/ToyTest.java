package com.反射;
//Class包含的方法
//getName() ||getCanonicalName() 获得类的完全限定类名
//getSimpleName() 获得非完全限定类名
//getInterface() 获得类实现的接口
//getSuperClass  获得类的父类
//isInterface()  判断是否为接口 返回布尔型
interface HasColor{
    java.awt.Color getColor();
}
interface HasBatteries{}
interface Waterproof{}
class Toy{
   Toy(){}//up.newInstance() 创建的类必须含有无参构造器
    Toy(int i){}
}
 class FancyToy extends Toy implements HasBatteries,Waterproof{
    FancyToy(){
        super(1);
    }
}
public class ToyTest{
    static void printInfo(Class cc){
        System.out.println("Class name:"+ cc.getName()+" is Interface? ["+cc.isInterface()+"]");
        System.out.println("Simple Class name:"+cc.getSimpleName());
        System.out.println("Canonical Class name:"+cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class c=null;
        try {
            c=Class.forName("com.反射.FancyToy");
        }catch (ClassNotFoundException e){
            System.out.println("Can't find Class!");
            System.exit(1);
        }
        printInfo(c);
        for (Class face:c.getInterfaces()
             ) {
            printInfo(face);
        }
        Object obj=null;
        Class up=c.getSuperclass();
        try {
            obj=up.newInstance();
        }catch (IllegalAccessException  e){
            System.out.println("Can't access!");
        }catch (InstantiationException e){
            System.out.println("Can't instance");
        }
        printInfo(obj.getClass());
    }

}
