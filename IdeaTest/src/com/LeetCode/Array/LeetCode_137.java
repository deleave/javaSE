package com.LeetCode.Array;

import java.util.HashMap;

public class LeetCode_137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int num: nums
             ) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int ans=0;
        for (int num:nums
             ) {
            if (map.get(num)==1)
                ans=num;
        }
        return ans;
    }
}
