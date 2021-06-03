package com.LeetCode.数学;

/**
 * @ClassName LeetCode_7
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/23 15:30
 * @Version 1.0
 **/
public class LeetCode_7 {
    public int reverse(int x) {
        String xstr = Integer.toString(x);
        String str = xstr;
        int flag = 1;
        if (x < 0) {
            flag = -flag;
            str.substring(1);
        }
        try {
            return Integer.parseInt(new StringBuffer(str).reverse().toString()) * flag;
        } catch (Exception e) {
            return 0;
        }

    }

    public int reverse1(int x) {
        long n=0;
        while (x!=0){
            n=n*10+x%10;
            x=x/10;
        }
        return (int) n==n?(int) n:0;
    }
}