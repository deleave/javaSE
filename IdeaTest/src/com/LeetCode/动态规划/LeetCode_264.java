package com.LeetCode.动态规划;

import java.util.LinkedList;
//三指针动态规划
// 由于除1外所有丑数都是与2，3，5相乘而来
// 所以dp[i]=min{dp[index1-1]*2,dp[index-1]*3,dp[index3-1]*5}
public class LeetCode_264 {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;//第1个丑数为1
        int index1 = 1;
        int index2 = 1;
        int index3 = 1;
        for (int i = 2; i <= n; i++) {
            int num1 = dp[index1] * 2;
            int num2 = dp[index2] * 3;
            int num3 = dp[index3] * 5;
            dp[i] = Math.min(Math.min(num1, num2), num3);//**
            if (dp[i] == num1) index1++;
            if (dp[i] == num2) index2++;
            if (dp[i] == num3) index3++;
        }
        return dp[n];

    }
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
