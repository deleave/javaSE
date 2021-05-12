package com.内部类;
//  内部类的继承
//
class withInner{

    withInner(){
        System.out.println("new withInner()");
    }
    class Inner{
        Inner(){
            System.out.println("withInner.new Inner()");
        }
        public void f(){
            System.out.println("withInner.Inner.f()");
        }
    }
    private Inner y=new Inner();
    public void g(){y.f();}
    public void insert(Inner yy){
        y=yy;
    }

    }

public class InheritInner extends withInner{
    class Inner extends withInner.Inner{

         Inner(){
            System.out.println("InheritInner.Inners()");
        }
        @Override
        public void f() {
            System.out.println("InheritInner.Inners.f()");
        }

    }
    InheritInner(){
        insert(new Inner());
    }
    public static void main(String[] args) {
        withInner w3=new InheritInner();
        w3.g();
        withInner w2=new withInner();
        w2.g();
    }
}
