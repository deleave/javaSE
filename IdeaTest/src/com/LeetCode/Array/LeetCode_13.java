package com.LeetCode.Array;

/**
 * @ClassName LeetCode_13
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/15 10:36
 * @Version 1.0
 **/
public class LeetCode_13 {
    public static int romanToInt(String s) {

        int num = 0;
        if (s.length() == 0) return num;
        for (int j = 0; j < s.length() - 1; j++) {
            int cur = getVal(s.charAt(j));
            int nex = getVal(s.charAt(j + 1));
            if (cur < nex) {
                num -= cur;
            } else {
                num += cur;
            }
        }
        return num+getVal(s.charAt(s.length()-1));
    }

/*
    public static int getVal(char c){
        switch (c){
            case 'M': return 1000;
            case 'D': return 500;
            case 'C': return 100;
            case 'L': return 50;
            case 'X': return 10;
            case 'V': return 5;
            case 'I': return 1;
        }
        throw new IllegalArgumentException("unsupported character");
    }
*/

    private static int getVal(char c){
        switch (c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X' :
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        throw new IllegalArgumentException("unsupported character");
    }
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
