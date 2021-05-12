package com.容器;

import java.util.LinkedList;
import java.util.*;

//迭代器的使用
//Iterator<>类
//ListIterator<>类（具有前后两个方向遍历链表，且可以产生两个索引）
//通用方法 iter.next()跳过一个元素返回上一元素
//iter.hasnext() 是否到表尾 iter.remove() 删除元素
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> a=new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        a.add("Rachel");
        List<String> b=new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("France");
        b.add("Curry");
        b.add("Gloria");
        LinkedList<String> c=new LinkedList<>();
        c.add("Second");
        c.addFirst("First");
        c.addAll(Integer.parseInt("2"),Arrays.asList("ss","cc","ee","bb","vv"));//添加到s后
        System.out.println(c);

        ListIterator<String> aIter=a.listIterator();
        Iterator<String> bIter= b.iterator();
        //将b链表添加到a中
        while (bIter.hasNext()){
            if(aIter.hasNext())
                aIter.next();
            aIter.add(bIter.next());
        }

        System.out.println("当前位置的索引: "+aIter.nextIndex());//返回当前位置的索引
        System.out.println(a);
        //每隔一个元素删除b链表中的一个元素
        bIter=b.iterator();//重置迭代器
        while (bIter.hasNext()){
            bIter.next();
            if (bIter.hasNext()){
                //删除操作应与next（）方法绑定
                bIter.next();
                bIter.remove();
            }
        }
        System.out.println(b);
    }
}
