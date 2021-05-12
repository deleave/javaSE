package com.LeetCode.Array;

import java.util.TreeSet;
//算法思想：滑动窗口+TreeSet集合
// 滑动窗口中用到了左右两个指针
// 右指针主动向前，且只移动一步，目的是为了探索未知区域。
// 左指针由右指针拖动向前，可以一次移动多步，目的是为了寻找满足题意的区间
//TreeSet是无重复的排序集合
public class LeetCode_220 {
    //该题的滑动区间的长度为k，每次遍历到元素 x 时，滑动窗口中包含元素 x前面的最多 k 个元素
    // 若满足区间{x-t，x+t} 则符合条件
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(k<0||t<0) return false;
        TreeSet<Long> set=new TreeSet<>();
        for (int i=0;i< nums.length;i++){
            // TreeSet两个重要方法
            // floor(E e) 方法返回在这个集合中小于或者等于给定元素的最大元素，如果不存在这样的元素,返回null. floor下界
            //ceiling(E e) 方法返回在这个集合中大于或者等于给定元素的最小元素，如果不存在这样的元素,返回null.
            // set.ceiling((long)nums[i]-(long)t); 表示 ceiling大于等于x-t的最小元素 ceiling上界
            Long ceiling= set.ceiling((long)nums[i]-(long)t);
            //ceiling<=nums[i]+i 表示ceiling小于等于x+t
            if (ceiling!=null&&ceiling<=(long)nums[i]+(long) t){
                return true;
            }
            set.add((long)nums[i]);
            if (i>=k){
                set.remove((long)nums[i-k]);
            }
        }

        return false;
    }
}
