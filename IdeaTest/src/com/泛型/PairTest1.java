package com.泛型;
//调用泛型类PairDemo.java
public class PairTest1
{
    public static void main(String[] args)
    {
        String[] words = { "Mary", "had", "a", "little", "lamb" };
        PairDemo<String> mm = ArrayAlgb.minmax(words);//泛型实例化
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}

class ArrayAlgb
{
    /**
     * Gets the minimum and maximum of an array of strings.
     * @param a an array of strings
     * @return a pair with the min and max value, or null if a is null or empty
     */
    public static PairDemo<String> minmax(String[] a)
    {
        //检查形参的合法性
        if (a == null || a.length == 0) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++)
        {
            //String类实现了compareTo接口
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new PairDemo<String>(min, max);
    }

}


