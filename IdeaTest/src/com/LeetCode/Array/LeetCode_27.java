package com.LeetCode.Array;

public class LeetCode_27 {
    public  static int removeElement(int[] nums, int val) {
        //对撞指针
        if(nums.length==0||nums==null) return 0;
        if(nums.length==1&&nums[0]==val) return 0;
        int n=nums.length;
        int left=0;//指向位置不变
        int right=n-1;
        while (left<right){
            if (nums[left]==val){
                nums[ left]=nums[right];
                right--;
            }
            left++;
        }
        return left;
    }
    public  static int removeElement1(int[] nums,int val){
        //快慢指针
        if(nums.length==0||nums==null) return 0;
        if(nums.length==1&&nums[0]==val) return 0;
        int left=0;
        int right=0;
        while (right<nums.length){
            if (nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
                right++;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums={0,1,2,2,3,0,4,2};
        int len = removeElement(nums, 2);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.println((nums[i]));
        }

    }
}
