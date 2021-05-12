package com.泛型;
//泛型实例化例子
//语法：<T extends BoundingType>
//类型参数：T extends BoundingType
//类型变量：T
//有时泛型类或泛型方法需要对类型变量加以约束。需要对类型参数的取值进行一定的限制，以便类型参数在指定的范围内。
//        1）	限制此类型参数必须继承自指定的父类或同类
//        2）	可以将BoundingType类称为此类型参数T的上界。
//        3）	当类型参数T不是BoundingType的同类或子类是都会产生编译错误
//Extends表示T应该是绑定类型的子类型（subtype）。
//T的类型实参的取值范围为绑定类型所限制的类型。T的绑定类型可以是类，也可以是接口。
//一个类型变量或通配符可以有多个限定类型，它们之间是与的关系，例如：T extends Comparable & Serializable。
// 如果用一个类作为限定，它必须是限定列表中的第一个（这里是Comparable接口类）。
import java.util.*;
public class PairTest2
{
    public static void main(String[] args)
    {
        GregorianCalendar[] birthdays =
                {
                        new GregorianCalendar(1906, Calendar.DECEMBER, 9), // G. Hopper
                        new GregorianCalendar(1815, Calendar.DECEMBER, 10), // A. Lovelace
                        new GregorianCalendar(1903, Calendar.DECEMBER, 3), // J. von Neumann
                        new GregorianCalendar(1910, Calendar.JUNE, 22), // K. Zuse
                };
        PairDemo<GregorianCalendar> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst().getTime());
        System.out.println("max = " + mm.getSecond().getTime());
    }
}

class ArrayAlg
{
    /**
     Gets the minimum and maximum of an array of objects of type T.
     @param a an array of objects of type T
     @return a pair with the min and max value, or null if a is
     null or empty
     */
    public static <T extends Comparable> PairDemo<T> minmax(T[] a)
    {
        if (a == null || a.length == 0) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new PairDemo<>(min, max);
    }
}

