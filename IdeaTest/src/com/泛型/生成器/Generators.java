package com.泛型.生成器;

import java.util.*;

public class Generators{
    public static <T> Collection<T>
    fill(Collection<T> collection, Generator<T> generator, int n){
        for (int i=0;i<n;i++){
            collection.add(generator.next());
        }
        return collection;
    }

    public static void main(String[] args) {
        //生成器
        Collection<Integer> fnumber=fill(new ArrayList<Integer>(),new Fibonacci(),10);
        for (int i:fnumber
             ) {
            System.out.println(i+" ");
        }
    }
}
