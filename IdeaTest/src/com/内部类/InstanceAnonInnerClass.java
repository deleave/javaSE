package com.内部类;
//内部类——匿名内部类的语法
 class FatherofAnonIn{
    protected int a;
    FatherofAnonIn(int a){
        this.a = a;
    }
}

class InstanceAnonOut {
    private int age = 12;

    public void Print(int x) {
        int m = 8;

//1. 创建FatherofAnonIn类的派生匿名类
//2. 匿名内部类不能有定义的实例构造器,将实例构造器参数传递给父类实例构造器进行初始化。
//3. 生成匿名内部类的实例对象
//4. 通过匿名内部类的实例对象调用匿名类的方法
        (new FatherofAnonIn(10){
            public void inPrint() {
                System.out.println(age);
                System.out.println(x);
                System.out.println(m);
                System.out.println(a);
            }
        }).inPrint();
    }
}

public class InstanceAnonInnerClass {
    public static void main(String[] args) {
        InstanceAnonOut out = new InstanceAnonOut();
        out.Print(3);
    }
}

