package com.LeetCode.哈希表;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName LeetCode_3
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/18 16:31
 * @Version 1.0
 **/
public class LeetCode_3 {
    //滑动窗口(双指针)解法
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //优化 避免窗口缓慢增加和减少,一次改变窗口的大小
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    //继续优化:用数据代替hashmap,用字符的ASCll码值代替key
    public int lengthOfLongestSubstring2(String s) {
        int n=s.length();
        int[] index=new int[128];
        int ans=0;
        for (int i=0,j=0;j<n;j++){
            i=Math.max(index[s.charAt(j)],i);
            ans=Math.max(ans,j-i+1);
            index[s.charAt(j)]=j+1;
        }
        return ans;
    }
}
