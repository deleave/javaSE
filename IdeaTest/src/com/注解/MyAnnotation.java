package com.注解;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;


@Inherited
@Repeatable( MyAnnotations.class)//可重复注解 jdk1.8后可使用
@Retention(RetentionPolicy.RUNTIME)// 修饰Annotation的生命周期: SOURCE/CLASS(默认行为)/RUNTIME 只有RUNTIME才可以被方式获取.
//指定Annotation可修饰的范围 TYPE:class,interface LOCAL_VARIABLE:局部变量
@Target({TYPE,FIELD,METHOD,PARAMETER,CONSTRUCTOR,LOCAL_VARIABLE})
public @interface MyAnnotation {
    //注解的成员变量是一个方法形式的变量
    String value() default "hello";
}
