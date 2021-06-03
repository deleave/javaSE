package com.泛型.课件代码;

//【pair1\PairDemo.java 】泛型源程序文件
//泛型类定义中叫类型参数：类型参数       = 类型变量       + 类型限制
//类型参数在没有类型限制时就是类型变量，有时简称为类型变量
//泛型类体中叫类型变量
//Java中，类型变量的命名规范：
// 1）	类型变量使用大写形式，且比较短
// 2）	使用变量E表示集合的元素类型
// 3）	K和V分别表示表的关键字与值的类型
// 4）	T（需要时还可以用临近的字母U和S）表示“任意类型”

public class PairDemo<T>
{


    public PairDemo() { first = null; second = null; }
    public PairDemo(T first, T second) { this.first = first;  this.second = second; }

    //输出时，不需要进行强制类型装换，编译器知道返回的具体类型，而不是Object
    public T getFirst() { return first; }
    public T getSecond() { return second; }

    //输入时，编译器要进行强制类型检查，可能出现编译错误
    //出现编译错误，比类在运行时出现类的强制类型转换异常要好的多。
    public void setFirst(T newValue) { first = newValue; }
    public void setSecond(T newValue) { second = newValue; }

    private T first;
    private T second;
}

