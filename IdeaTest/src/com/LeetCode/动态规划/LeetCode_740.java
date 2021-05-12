package com.LeetCode.动态规划;

public class LeetCode_740 {
    public int deleteAndEarn(int[] nums) {
        int n=nums.length;
        if (n<=1) return nums[0];
        int[] dp=new int[n+1];
        int[] trans=new int[20001];
        for (int i=0;i<n;i++){
            trans[nums[i]]=nums[i];
        }
        for (int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+trans[i]);
        }
        return dp[0];
    }
}
