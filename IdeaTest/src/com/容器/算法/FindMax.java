package com.容器.算法;

import java.util.*;

public class FindMax {
    //链表实现
    public static <T extends Comparable> T Max1(Collection<T> a){
        if (a.isEmpty()) throw new NoSuchElementException();
        Iterator<T> iter= a.iterator();
        T largest=iter.next();
        while (iter.hasNext()){
            T next=iter.next();
            if(largest.compareTo(next)<0)
                largest=next;
        }
        return largest;
    }
    //数组列表实现
    public static <T extends Comparable> T Max2(ArrayList<T> b){
        if (b.isEmpty()) throw new NoSuchElementException();
        T largest=b.get(0);
        for (int i=0;i<b.size();i++){
            if (largest.compareTo(b.get(i))<0){
                largest=b.get(i);
            }
        }
        return largest;
    }
    //数组实现
    public static <T extends Comparable> T Max3(T[] c){
        if (c.length==0) throw new NoSuchElementException();
        T largest=c[0];
        for (int i=1;i< c.length;i++){
            if (largest.compareTo(c[i])<0)
                largest=c[i];
        }
        return largest;
    }

    public static void main(String[] args) {
        ArrayList b=new ArrayList(Arrays.asList(5,7,3,8,9,2,4));
        LinkedList<Integer> a=new LinkedList<>(Arrays.asList(3,6,2,7,5,9));
        Integer[] c={5,89,45,35,78,25};//int[] 无法传入到泛型数组中
        System.out.println(FindMax.Max1(a));
        System.out.println(FindMax.Max2(b));
        System.out.println(FindMax.Max3(c));

    }
 }
