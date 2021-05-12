package com.接口;
class A{
    interface B{
        void f();
    }
    //公共实现BImp
    public class BImp implements B{
        public void f(){}
    }
    //私有实现BImp2
    private class BImp2 implements B{
        public void f(){}
    }
    //类中可以设置接口
    public interface C{
        void f();
    }
    //包内实现
    class CImp implements C{
        public void f(){}
    }
    //私有实现
    private class CImp2 implements C{
        public void f(){}
    }
    //类中可以设置私有接口
    //不允许向上转型
    private interface D{
        void f();
    }
    //私有实现
    private class DImp implements D{
        public void f(){}
    }
    //公共实现
    //但只能被其自身所用不能说实现了接口D
    public class DImp2 implements D{
        public void f(){}
    }
    public D getD(){
        return new DImp2();
    }
    private D dRef;
    public void receiveD(D d){
        dRef=d;
        dRef.f();//动态绑定
    }
}
//接口嵌套
interface E{
    interface G{
        void f();
    }
    //默认为public 不必添加
    public interface H{
        void f();
    }
    void g();
    //! private interface I{}
    //接口内不能设置私有接口
}
public class NestingInterfaces {
    public class BImp implements A.B{
        public void f(){}
    }
    class CImp implements A.C{
        public void f(){}
    }
    //不能实现一个私有接口除非在类的内部实现
    //    class DImp implements A.D{
    //        public void f(){}
    //    }
    class EImp implements E{
        public void g(){}
    }
    class EGImp implements E.G{
        public void f(){}
    }
    class EImp2 implements E{
        public void g(){}
        class EG implements E.G{
            public void f(){}
        }
    }

    public static void main(String[] args) {
        A a=new A();
        //无法使用A类中的私有接口变量
        // A.D ad=a.getD();
        //无权使用返回值 new DImp2;
        //public class DImp2 implements D{public void f(){}}虽然公共实现了私有接口但只能被自身使用
        //
        //A.DImp2 di2=  a.getD();
        //只能将返回值交给有权使用的receiveD()方法
        A a2=new A();
        a2.receiveD(a.getD());
    }
}
