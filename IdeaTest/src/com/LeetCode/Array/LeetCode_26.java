package com.LeetCode.Array;

//算法思想：双指针->快慢指针
public class LeetCode_26{
    //数组元素不能重复
        public static int removeDuplicates1(int[] nums) {
            if(nums.length==0||nums.length==1){
                return nums.length;
            }
            int slow=0;
            int fast=1;
            while(fast<nums.length){
                if(nums[slow]==nums[fast]){
                    fast++;
                }
                else{
                    slow++;
                    nums[slow]=nums[fast];
                    fast++;
                }

            }

            return slow+1;
        }

    //数组元素最多重复2次
        public static int removeDuplicates2(int[] nums) {
            if(nums.length==0||nums.length==1)
                return nums.length;
            int slow=2;
            int fast=2;
            while(fast<nums.length){
                if(nums[slow-2]!=nums[fast]){
                    nums[slow]=nums[fast];
                    slow++;
                }
                fast++;
            }
            return slow;
        }
    public static void main(String[] args) {
            //无重复
            int[] a={1,1,1,2,2,3,};
//            int len1=DeletesDuplicateItem.removeDuplicates1(a);
          /*  for (int i=0;i<len1;i++){
                System.out.println(a[i]);
            }*/
            //有重复（最多两个）
            int len2=LeetCode_26.removeDuplicates2(a);
            System.out.println(len2);
            for (int i=0;i<len2;i++){
                System.out.println(a[i]);
            }
    }

}


