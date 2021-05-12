package com.LeetCode.Array;

import org.junit.Test;
//对于这种要求空间复杂度的，我们可以先考虑如果有一个等大的空间，我们可以怎么做。
// 然后再考虑如果直接用原数组怎么做，主要是要保证数组的信息不要丢失。
// 目前遇到的，主要有两种方法就是交换和取相反数。
/**
 * @ClassName LeetCode_41
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/9 10:09
 * @Version 1.0
 **/
public class LeetCode_41 {
    //交换 标记下标
    public int firstMissingPositive(int[] nums) {
      int n=nums.length;
      for (int i=0;i<n;i++){
          while (nums[i]>0&&nums[i]<=n&&nums[i]!=nums[nums[i]-1]){
              swap(nums,i,nums[nums[i]-1]);
          }
      }
      for (int i=0;i<n;i++){
          if (nums[i]!=i+1){
              return i+1;
          }
      }
      return n+1;
    }
    @Test
    public void testfirstMissingPositive2(){
        int[] nums=new int[]{3,4,-1,1,8};
        System.out.println(firstMissingPositive2(nums));
    }
    //取相反数 作为标记
    public int firstMissingPositive2(int[] nums) {
        int n=nums.length;
        //将正数移到前面 并返回正数的个数
        int k=positiveNums(nums);
        for (int i=0;i<k;i++){
            //将要标记的下标
            int index=Math.abs(nums[i])-1;
            if (index<k){
                //标记位的数重新置为正数
                int temp=Math.abs(nums[index]);
//                System.out.println("temp"+i+":"+temp);
                //把正数当做 false，所以将正数置为相反数作为false标记
                nums[index]=temp<0?temp:-temp;
//                System.out.println("nums[index]"+1+":"+nums[index]);
            }
        }
        for (int i=0;i<k;i++){
            if (nums[i]>0){
                return i+1;
            }
        }
        return k+1;
    }

    private int positiveNums(int[] nums) {
        int p=0;
        for (int i=0;i<nums.length;i++
             ) {
            if (nums[i]>0){
                swap(nums,i,p);
                p++;
            }
        }
        return p;
    }

    private void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
