package com.泛型;
import java.util.*;
//Set的实用工具
public class Sets {
    //并集
    public static <T> Set<T> union(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<T>(a);
        result.addAll(b);
        return  result;
    }
    //交集
    public static <T>
    Set<T> intersection(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }
    //a-b
    public static <T>
    Set<T> difference(Set<T> a,Set<T> b){
        Set<T> result=new HashSet<T>(a);
        result.remove(b);
        return result;
    }
    //a,b的并集-a,b的交集
    public static <T> Set<T> complement(Set<T> a,Set<T> b){
        return difference(union(a, b),intersection(a, b));
    }
}
