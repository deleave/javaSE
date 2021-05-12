package com.LeetCode.Array;

import java.util.Arrays;

class Solution1{
    public int[] twoSum(int[] nums, int target) {
        for (int i=0;i<nums.length;i++)
        for (int j=i+1;j<nums.length;j++){
            if (nums[i]+nums[j]==target){
               return new int[]{i,j};//匿名数组
            }
        }
        return new int[0];
    }
}
class Solution2{
    
}
public class TwoSum {
    public static void main(String[] args) {
      int[] nums=new int[]{2,7,11,15};
        Solution1 sol=new Solution1();
        System.out.println(Arrays.toString(sol.twoSum(nums,9)));
    }
}
