package com.泛型.生成器;

import com.反射.Students;

//通用的生成器 可以生成某个类的对象。
//类必须有以下两个特点
// 1）有无参构造器
// 2)必须public
public class BasicGenerator <T>implements Generator<T> {
    private Class<T> type;
    public BasicGenerator(Class<T> type){
        this.type=type;
    }
    public T next(){
        try{
            return type.newInstance();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static <T> Generator<T> creat(Class<T> type){
        return new BasicGenerator<T> (type);
    }
}
