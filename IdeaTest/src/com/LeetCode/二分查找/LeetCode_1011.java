package com.LeetCode.二分查找;


import java.util.Arrays;
import java.util.stream.IntStream;

public class LeetCode_1011 {
    // 二分查找 答案落在{max【weight】,sum[weight]}之间 mid为当前货船
    public int shipWithinDays1(int[] weights, int D) {
        int n = weights.length;
        Arrays.sort(weights);
        int low = weights[n-1];
        int high = IntStream.of(weights).sum();
        while (low < high) {
            int mid = (low + high) / 2; //表示当前船只的载重
            int tem = 0;//表示当前货物的重量
            int day = 1;//表示运输天数

            for (int w : weights
            ) {
                tem += w;
                //载不动当前货物 再来一天
                if (tem > mid) {
                    day++;
                    tem=w;
                }
                if (day>D) {
                    low++;
                }
                else if (day<=D)
                    high=mid;
            }
        }
        return low;
    }
    public int shipWithinDays(int[] weights, int D) {
        int n = weights.length;
        int low=0,high=0;
        for(int i=0;i<n;i++){
            low=Math.max(weights[i],low);
            high+=weights[i];
        }
        if(D==1)  return high;
        while (low < high) {
            int mid =(high+low) / 2; //表示当前船只的载重
            int tem = 0;//表示当前货物的重量
            int day = 1;//表示运输天数

            for (int w : weights
            ) {
                //载不动当前货物 再来一天
                if (tem + w > mid) {
                    ++day;
                    tem = 0;
                }
                tem += w;
            }
            if (day>D) {
                low=mid+1;
            }
            else if (day<=D)
                high=mid;
        }
        return low;
    }
}
