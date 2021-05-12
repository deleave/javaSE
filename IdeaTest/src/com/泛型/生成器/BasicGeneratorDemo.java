package com.泛型.生成器;

import com.反射.Students;

public class BasicGeneratorDemo {
    public static void main(String[] args) {
        Generator<Students> generator=BasicGenerator.creat(Students.class);
        for(int i=0;i<5;i++){
            System.out.println(generator.next());
        }
    }
}
