package com.LeetCode.二分查找;

//算法思想：忽略不包含最小值的数组部分
//
public class Find {
    public static int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid+1;
            }

        }
        return nums[low];

        }
    public static int findMin1(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]<nums[high]){
                high=mid;
            }
            else if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else {
                 high--;
            }

        }
        return nums[low];
    }

    public static void main(String[]args){
        int[] nums = {3,3,1,3};
        System.out.println(findMin1(nums));

    }
}
