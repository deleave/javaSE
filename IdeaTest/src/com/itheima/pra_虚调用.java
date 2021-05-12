package com.itheima;

class Father{
    private int a=1;
    public void fMethod()
    {
        this.a=a;
    }
}
class Son extends Father{
    private int a=2;
    public void sMethod(){
    this.a=a;
}
}
public class pra_虚调用 {
    public static void main(String[] args) {
        Father father=new Father();
        Son son=new Son();
        Father fs;
        fs=son;
        fs.fMethod();
       // fs.sMethod(); Father类中无sMethod方法，
    }
}

