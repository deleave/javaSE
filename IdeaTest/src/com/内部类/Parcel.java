package com.内部类;
//内部类被隐藏在外部类中
interface Contents{
    void f();
}
public class Parcel {
    public class Content implements Contents{
        public void f(){
            System.out.println("f()"+" ");
        }
    }
    public Content g()
    {
        return new Content();
    }
public static void test(Contents s){
    System.out.println(s);
}

    public static void main(String[] args) {
        Parcel p=new Parcel();
        Contents s=p.g();
        s.f();
        //(Content)s.f();不可转型
    }
}

