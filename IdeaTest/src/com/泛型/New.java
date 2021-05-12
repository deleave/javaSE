package com.泛型;

import java.util.*;

//类型参数判断 即咋创建对象时指明类型参数的值 但在使用泛型方法时不必指明
public class New {
    public static <K,V> Map<K,V> map(){
        return new HashMap<K,V>();
    }
    public static <T> List<T> list(){
        return new ArrayList<T>();
    }
    public static <T> LinkedList<T> lList(){
        return new LinkedList<T>();
    }
    public static <T> Set<T> set(){
        return new HashSet<T>();
    }
    public static <T> Queue<T> queue(){
        return new LinkedList<>();
    }
}
