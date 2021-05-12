package com.泛型.元组;
//仅用一个方法就能返回多个对象
public class Twotuple<A,B> {
    public final A first;
    public final B second;

    public Twotuple(A a, B b) {
        first = a;
        second = b;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }
}
