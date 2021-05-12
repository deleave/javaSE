package com.LeetCode.数学;

public class LeetCode_1720 {
    public int[] decode(int[] encoded, int first) {
        int n=encoded.length;
        int[] arr=new int[n+1];
        arr[0]=first;
        for (int i=0;i<encoded.length;i++) {
            arr[i+1]=encoded[i]^arr[i];
        }
        return arr;
    }
}
