package com.泛型.元组;

public class Fourtuple<A,B,C,D>extends Treetuple<A,B,C> {
    public final D fourth;
    public Fourtuple(A a, B b, C c, D fourth) {
        super(a, b, c);
        this.fourth = fourth;
    }
    public String toString(){
        return "("+first+","+second+","+third+","+fourth+")";
    }
}
