package com.LeetCode.String;

/**
 * @ClassName LeetCode_9
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/27 12:52
 * @Version 1.0
 **/
public class LeetCode_9 {

    public  boolean  isPalindrome(int x) {
        if (x<0) return false;
        String str=Integer.toString(x);
        int n=str.length();
        if (str.charAt(0)==str.charAt(n-1)){
            return true;
        }
        return false;

    }

    public  boolean  isPalindrome1(int x) {
        if (x<0) return false;
        int rev=reverse(x);
        return  rev==x;
    }

        public int reverse(int x) {
        long n=0;
        while (x!=0){
            n=n*10+x%10;
            x=x/10;
        }
        return (int) n==n?(int) n:0;
    }

    }
