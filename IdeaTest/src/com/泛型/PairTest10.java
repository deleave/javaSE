package com.泛型;
//实例化泛型方法
public class PairTest10{
    public static void main(String[] args) {
        String[] names = {"aa", "bb", "cc"};
        //实例化泛型方法
        String middle = ArrayA.<String>getMiddle(names);
        //String middle = ArrayA.getMiddle(names);
//方法调用中可以省略<String>类型实参列表，编译器有足够的信息能够推断出所调用的方法。
//同理：从Java 7 开始，实例化泛型类时只需要给出一对尖括号<>即可，编译器根据变量的类型，就可以推断出尖括号中的类型实参信息。
//Pair<String> myPair = new Pair<String>(“Zhang”,”Li”);
//Pair<String> myPair = new Pair<>(“Zhang”,”Li”);
        //编译器用String[]与泛型类型T[]进行匹配并推断出T一定是String，即可以用简化的调用
        // String middle = ArrayA.getMiddle(names);

        System.out.println("middle = " + middle);
    }
}

//泛型方法，注意：类型参数放在修饰符（这里是 public static）的后面，返回类型的前面。
class ArrayA {
    public static <T> T getMiddle(T[] a) {
        return a[a.length / 2];
    }
}
