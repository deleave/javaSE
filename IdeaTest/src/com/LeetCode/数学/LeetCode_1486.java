package com.LeetCode.数学;

/**
 * @ClassName LeetCode_1486
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/7 9:39
 * @Version 1.0
 **/
public class LeetCode_1486 {
    public int xorOperation(int n, int start) {
        int ans=0;
        for(int j=0;j<n;j++){
            ans^=(start+2*j);
        }
        return ans;

    }
}
