package com.LeetCode.动态规划;

import java.util.HashMap;

public class LeetCode_377 {
//    递归
    public int combinationSum41(int[] nums, int target) {
        if (target==0) return 1;
        int res=0;
        for (int n:nums){
            if (target>=n)
            res+=combinationSum41(nums,target-n);
        }
       return res;
    }
//    记忆化搜索
//    记录递归数据 减少递归次数
public int combinationSum42(int[] nums, int target) {
    HashMap<Integer,Integer> memorization =new HashMap<>();
    return getres(nums,target,memorization);
}
private int getres(int[] nums,int target,HashMap<Integer,Integer> map){
        if (target==0) return 1;
        int m=map.getOrDefault(target,-1);
        if (m!=-1) return m;
        int res=0;
    for (int n: nums
         ) {
        if (target>=n){
            res+=getres(nums,target-1,map);
        }
    }
    map.put(target,res);
      return res;
}
//动态规划
// 背包问题            通用状态方程：
// 背包组合问题        dp[i] += dp[i-num];
// true false问题：   dp[i] = dp[i] or dp[i-num]
// 最大最小问题：       dp[i] = min(dp[i], dp[i-num]+1)或者dp[i] = max(dp[i], dp[i-num]+1)
    public int combinationSum4(int[] nums, int target){
        int n=nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int i=1;i<=target;i++){
            for (int num:nums){
                if (i>=num){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }

}
