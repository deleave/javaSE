package com.泛型.元组;

class Amphibian{}
class Vehicle{}
public class TupleTest {
    static Twotuple<Amphibian,Integer> f(){
        return new Twotuple<Amphibian,Integer> (new Amphibian(),10);
    }
    //与f()相比没有将返回值作为参数化对象使用
    static Twotuple f2(){
        return new Twotuple(new Amphibian(),10);
    }
    static Treetuple<Vehicle,Amphibian,String>g(){
        return new Treetuple<Vehicle,Amphibian,String>(new Vehicle(),new Amphibian(),"hi");
    }
    static Fourtuple<Double,Amphibian,Vehicle,Float>h(){
        return new Fourtuple<Double,Amphibian, Vehicle,Float>(3.1,new Amphibian(),new Vehicle(), (float)4.2);
    }

    public static void main(String[] args) {
        Twotuple<Amphibian,Integer> test=f();
        System.out.println(f2());
        System.out.println(test);
        System.out.println(g());
        System.out.println(h());

    }
}
