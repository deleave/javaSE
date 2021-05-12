package com.LeetCode.二分查找;


public class Binary {
        public static int search1(int[] nums, int target) {
            if(nums.length==0)
                return -1;
            if(nums.length==1)
                return target==nums[0]?0:-1;
            int left=0; int right=nums.length-1;
            while(left<=right){
                int mid= left+(right-left)/2;
                if(nums[mid]==target)
                    return mid;
                //与nums[left]判断在nums[mid]左右段
                if(nums[mid]>=nums[left]){
                    //在left右端
                    if(target<=nums[mid]&&target>=nums[left])
                    {
                        right=mid-1;
                    }
                    else{
                        left=mid+1;
                    }
                }
                else
                {
                    if(target>=nums[mid]&&target<=nums[right])
                    {
                        left=mid+1;
                    }
                    else{
                        right=mid-1;
                    }
                }

            }
            return -1;

        }
    public static boolean search2(int[] nums, int target) {
        if(nums.length==0)
            return false;

        int left=0; int right=nums.length-1;
        while(left<=right){
            int mid= left+(right-left)/2;
            if(nums[mid]==target)
                return true;
            //与nums[left]判断在nums[mid]左右段
            if(nums[mid]>nums[left]){
                //在left右端[left,mid]有序
                if(target<=nums[mid]&&target>=nums[left])//target在[left,mid]
                {
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
            else if (nums[mid]<nums[left])
            {
                if(target>=nums[mid]&&target<=nums[right])//[mid,right]
                {
                    left=mid;
                }
                else{
                    right=mid-1;
                }
            }
            else {

                if (nums[left]==target)
                return true;
                else {
                    left++;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums={1,0,1,1,1};

//        int re=search1(nums,0);
        System.out.println(search2(nums,0));
    }
    }
