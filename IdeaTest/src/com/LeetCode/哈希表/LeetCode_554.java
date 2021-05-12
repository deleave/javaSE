package com.LeetCode.哈希表;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_554 {
    public int leastBricks(List<List<Integer>> wall) {

        Map<Integer,Integer> map= new HashMap<>();
        for(List<Integer> widths :wall){
            int n=widths.size();
            int sum=0;
            for (int i=0;i<n-1;i++){
                sum+=widths.get(i);
                //getOrDefault(sum,0)当map中有key为sum时返回sum的value，否则返回0
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        int ans=0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            ans=Math.max(ans,entry.getValue());
        }
        return wall.size()-ans;
    }
}
