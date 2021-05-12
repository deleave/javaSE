package com.泛型.元组;

public class Treetuple<A,B,C>extends Twotuple<A,B> {
    public final C third;
    public Treetuple(A a,B b,C c){
        super(a,b);
        third=c;
    }
    public String toString(){
        return "("+first+","+second+","+third+")";
    }
}
