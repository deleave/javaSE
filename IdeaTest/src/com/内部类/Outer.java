package com.内部类;

public class Outer {
    private String str="Understand";
    class Inner{
        private String msg="don't understand";
        public String toString(){
            return msg;
        }
        public Outer DoThis(){
            return Outer.this;
        }
    }
    public Inner in(){
        return new Inner();
    }

    public static void main(String[] args) {
        Outer outer=new Outer();
        Outer.Inner c= outer.in();
        System.out.println(c.toString());
        System.out.println(c.DoThis().str);
        System.out.println(outer.str);
        System.out.println(c.msg);
    }
}
