package com.反射;

import java.io.Serializable;

/**
 * @ClassName Person
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/18 21:04
 * @Version 1.0
 **/
public class Person<T> implements Serializable {
    private char gender;
    public double weight;
    private void breath(){
        System.out.println("呼吸");
    }

    public void eat(){
        System.out.println("进食");
    }
}
