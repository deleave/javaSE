package com.LeetCode.动态规划;

public class LeetCode_53 {
    //动态规划  dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        if (n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        int sum=nums[0];
     /*   for (int num:nums){
            max=Math.max(num,max+num);
            sum=Math.max(max,sum);
        }*/
        for (int i=1;i<n;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            sum=Math.max(dp[i],sum);
        }
        return sum;
    }
    //用 全部和减去最小和
    public int maxSubArray1(int[] nums){
        int sum_all=0;
        int min_all=0;
        int res=Integer.MIN_VALUE;

        if (nums.length==1) return nums[0];
        for (int num:nums){
            sum_all+=num;
            res=Math.max(res,sum_all-min_all);
            min_all=Math.min(min_all,sum_all);
        }
        return res;
    }

}
