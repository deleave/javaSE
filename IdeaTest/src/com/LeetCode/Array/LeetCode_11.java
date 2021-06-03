package com.LeetCode.Array;

/**
 * @ClassName LeetCode_11
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/30 15:22
 * @Version 1.0
 **/
public class LeetCode_11 {
    //暴力枚举(超时)
    public int maxArea(int[] height) {
        int maxWater=0;
        int len=height.length;
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len ;j++){
                int h=Math.min(height[i],height[j]);
                if (h*(j-1)>maxWater){
                    maxWater=h*(j-1);
                }
            }
        }
        return maxWater;
    }

    //双指针
    public static int maxArea2(int[] height) {
        int maxarea=0;
        int l=0;
        int r=height.length-1;
        while (l<r){
            maxarea=Math.max(maxarea,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]){
                l++;
            }else{
                r--;
            }
        }
        return  maxarea;
    }

    public static void main(String[] args) {
        int[] height={1,8,6,2,5,4,8,3,7};
        int i = maxArea2(height);
        System.out.println(i);
    }

}
