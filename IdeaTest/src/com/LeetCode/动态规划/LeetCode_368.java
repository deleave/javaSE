package com.LeetCode.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//动态规划：某个状态的转移依赖于与前一个状态的关系
// 状态转移方程：dp[i]表示nums数组0~i位置最长整除集个数
// dp[i]的变更依赖于前一位置dp[i-1]的最长整除集合的个数
// dp[i]=Math.max(dp[i],dp[j]+1);
public class LeetCode_368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        int[] dp=new int[n];
        Arrays.sort(nums);
        Arrays.fill(dp,1);
        int maxSize=1;
        int maxVal=dp[0];
        for(int i=1;i<n;i++){
            for (int j=0;j<i;j++){
                if (nums[i]%nums[j]==0){
                   dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>maxSize){
                maxSize=dp[i];
                maxVal=nums[i];
            }

        }
        if (maxSize==1) {
            res.add(nums[0]);
            return res;
        }
        for (int i=n-1;i>=0&&maxSize>0;i--){
            if (maxSize==dp[i] && maxVal%nums[i]==0){
                maxVal=nums[i];
                res.add(nums[i]);
                maxSize--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(largestDivisibleSubset(new int[]{1, 2, 3}));
    }
}
