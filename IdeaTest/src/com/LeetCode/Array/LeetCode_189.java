package com.LeetCode.Array;

import java.util.Arrays;

/**
 * @ClassName LeetCode_189
 * @Description
 * @Author deleave
 * @Date 2021/5/9 9:10
 * @Version 1.0
 **/
public class LeetCode_189 {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n];
        for (int i=0;i<n;i++){
         ans [(i+k)%k]=nums[i];
        }
        System.arraycopy(ans,0,nums,0,n);
    }
    //空间复杂度O(1) 时间复杂度O(n)
    public void rotate2(int[] nums,int k){
        int n=nums.length;
        k=k%n;
        int count=gcd(k,n);//记录搬了多少数字
        for (int i=0;i<count;i++){
            int current=i;//记录当前位置
            int prev=nums[i];
            do {
                //要移动的位置
                int next=(current+k)%n;
                //将移动数字缓存
                int temp=nums[next];
                //将数字搬过来
                nums[next]=prev;
                prev=temp;
                //更新下一次移动的位置
                current=next;
            }while (i!=current);
        }
    }
    //最小公倍数
    private int gcd(int x,int y){
        return y>0?gcd(y,x%y):x;
    }
    //翻转数组 将全部数组翻转后 再将[0，k%n-1]和[k,n-1]分别翻转，即得到结果
    public  void rotate3(int[] nums,int k){
      k%=nums.length;
      reverse(nums,0, nums.length-1);
      reverse(nums,0,k-1);
      reverse(nums, k, nums.length-1);
    }
    private void reverse(int[] nums,int start,int end) {
        while (start<end){
            int temp=nums[end];
            nums[end]=nums[start];
           nums[start]=temp;
           end--;
           start++;
        }
    }
}
