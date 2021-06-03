package com.泛型.课件代码;

//【程序Pair.java】 弱类型的通用类型源程序文件
public class Pair1
{
    private Object first;
    private Object second;

    public Pair1() { first = null; second = null; }
    public Pair1(Object first, Object second) { this.first = first;  this.second = second; }

    public Object getFirst() { return first; }
    public Object getSecond() { return second; }

    public void setFirst(Object newValue) { first = newValue; }
    public void setSecond(Object newValue) { second = newValue; }

}


