package com.注解;

/**
 * @ClassName TestAnnotation
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/26 9:04
 * @Version 1.0
 **/
@MyAnnotation(value = "hi")
public class TestAnnotation {
    //可重复注解
    @MyAnnotation(value = "注解1")
    @MyAnnotation(value = "注解2")
    public void test(){

    }
}
