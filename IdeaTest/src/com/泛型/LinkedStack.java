package com.泛型;
//利用泛型实现栈
import java.util.ArrayList;

public class LinkedStack<T> {
    private static class Node<U>{
        U item;
         Node<U> next;
        Node(){
            item=null;
            next=null;
        }
        Node(U item,Node<U> next){
            this.item=item;
            this.next=next;
        }
        boolean end(){
            return item==null&&next==null;
        }
    }//内部类
    private Node<T> top=new Node<T>();//末端哨兵检查栈是否空
    public void push(T item){
        top=new Node<T>(item,top);
    }
    public T pop(){
        T result=top.item;
        if(!top.end()){
            top=top.next;
        }
        return result;
    }

    public static void main(String[] args) {
        LinkedStack<String> lss=new LinkedStack<String>();
        for (String s:"You complete me!".split(" ")
             ) {
            lss.push(s);
        }
       String s;
        while ((s=lss.pop())!=null){
            System.out.println(s);
        }
    }

}
