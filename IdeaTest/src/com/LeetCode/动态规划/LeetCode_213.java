package com.LeetCode.动态规划;
//动态规划得出状态方程dp[i]=max{dp[i-2],nums[i]+dp[i-1]};
public class LeetCode_213 {
    public int rob1(int[] nums){

        if (nums.length==0)
            return 0;
        int[] dp=new int[nums.length+1];
        dp[0]=nums[0];//初始值赋值
        if(nums.length>=2)//排除只有两个数据的情况
            dp[1]=Math.max(nums[0], nums[1]);
        for (int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],nums[i]+dp[i-2]);//状态方程
        }
        return dp[nums.length-1];//返回最后的值为最大的值
    }
    public int rob(int[] nums){
        //思想：数组头尾不能同时选
        // 将数组分成两个队列 为1——n 和0——n-1 分别动态规划求两个最大值
        // 对比两个结果返回最大的
        int n=nums.length;
        int[] nums1=new int[n-1];
        int[] nums2=new int[n-1];
        if (n==0) return 0;
        //对nums[0]--nums[n-1]进行动态规划求最大值
        System.arraycopy(nums,0, nums1, 0, nums.length-2);
       System.arraycopy(nums,1,nums2,0,nums.length-1);
    return Math.max(rob1(nums1), rob1(nums2));
    }
}
