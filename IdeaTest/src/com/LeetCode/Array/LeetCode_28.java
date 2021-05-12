package com.LeetCode.Array;

public class LeetCode_28 {
    //kmp法 寻找前缀表next【】 当遇到不匹配的情况，回溯到前缀表的值的下表上再进行匹配
    public void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }

            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }
    }

    public  int strStr(String haystack, String needle) {
        if (needle.length()==0) {
            return 0;
        }

        int[] next = new int[needle.length()];
        getNext(next, needle);
        int j = -1;
        for (int i = 0; i < haystack.length(); i++) {
            while (j >= 0 && haystack.charAt(i) != needle.charAt(j + 1)) {
                j = next[j];
            }
            if (haystack.charAt(i) == needle.charAt(j + 1)) {
                j++;
            }
            if (j == needle.length() - 1) {
                return (i - needle.length() + 1);
            }
        }

        return -1;
    }
//暴力法 将haystack所有长度与needle长度相同的子串，与needle比较
    public int strStr1(String haystack, String needle) {
        int n=haystack.length();
        int m=needle.length();
        boolean flag=true;
        for (int i=0;i+m<=n;i++){
            for (int j=0;j<m;j++){
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    flag=false;
                    break;
                }
            }
            if (flag){
                return i;
            }
        }
       return -1;
    }
//双指针
    public  int strStr2(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int left = 0, right = 0, index = 0;
        while (right < haystack.length() && index < needle.length()) {
            if (haystack.charAt(right) != needle.charAt(index)) {
                //若不相等
                left++;
                right = left;
                index = 0;
            } else {
                right++;
                index++;
            }
        }
        return index == needle.length() ? left : -1;
    }

    public static void main(String[] args) {
        LeetCode_28 l=new LeetCode_28();
        System.out.println(  l.strStr("hello","ll"));

    }

}


