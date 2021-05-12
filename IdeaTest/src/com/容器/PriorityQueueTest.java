package com.容器;

import java.util.PriorityQueue;
//优先级队列 按任意顺序插入，却总按照排序的顺序进行检索
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Item> pq=new PriorityQueue<>();
        pq.add(new Item("Toaster",12));
        pq.add(new Item("Widget",34));
        pq.add(new Item("Modem",78));
        pq.add(new Item("Amy",1));
        //相同实例存不进去
        pq.add(new Item("Amy",1));
        System.out.println("显示所有实例：");
        for (Item i:pq
             ) {
            System.out.println(i);
        }
        System.out.println("逐个删除元素");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
