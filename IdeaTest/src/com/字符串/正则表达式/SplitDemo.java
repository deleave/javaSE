package com.字符串.正则表达式;

import java.util.Arrays;
import java.util.regex.Pattern;

public class SplitDemo {
    public static String knights="Then,when you have found shrubbery, you must "+
            "cut down the mightiest tree in the forest... "+"with... a herring.";
    public static void split(String regex){
        System.out.println(Arrays.toString(knights.split(regex)));
    }

    public static void main(String[] args) {
        String sen="^[A-Z].*[\\.]$";
        split("the|you");
        System.out.println( knights.matches(sen));
        System.out.println(knights.replaceAll("[aeiou]","_"));
        //按照通用边界分割文本
        System.out.println(knights);
        System.out.println(Arrays.toString(Pattern.compile("you").split(knights)));
        //limit限制分割limit-1次
        System.out.println(Arrays.toString(Pattern.compile("you").split(knights,1)));

    }

}
