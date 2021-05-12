package com.itheima;

class Rock{
    int i=0;
  Rock increment()
  {
      ++i;
      return this;//this返回当前对象的引用
  }
    void print(){
        System.out.println("i="+i);
    }
}
public class practice {
    public static void main(String[] args) {
      Rock x=new Rock();
      x.increment().increment().increment().print();

    }
}
