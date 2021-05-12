package com.LeetCode.动态规划;

import java.util.HashMap;

public class LeetCode_91 {
//    方法一：直接递归
//    思路：对一串编码 ”232312341“ 对于第一个字母的解码
//    有两种解码方式： 2|32312341 或 23|2312341
//    对于右半部分 32312341 解码方式有ant1种
//               2312341 解码方式有ant2种
//    所以整体的解码方式就有ant1+ant2种
    public int numDecodings1(String s) {
        return getants1(s, 0);
    }

    private int getants1(String s, int start) {

        if (start == s.length()) return 1;//递归出口
        if (s.charAt(start) == '0') return 0;
        //首先得到第一种划分解码的方式
        int ant1 = getants1(s, start + 1);
        //对第二种解码方式测试 如果前两位小于等于26则 划分方式有ant1+ant2;
        int ant2 = 0;
        if (start < s.length()-1) {
            //前两位是否小于26
            int ten = (s.charAt(start) - '0') * 10;
            int one = (s.charAt(start + 1) - '0');
            if (ten + one <= 26) {
                ant2 = getants1(s, start + 2);
            }
        }
        return ant1 + ant2;
    }
// 方法二：
//   递归后保存数据避免重复计算
//    用 memoization 技术，就是算出一个结果后就保存
public int numDecodings2(String s) {
    HashMap<Integer,Integer> memorization =new HashMap<>();
    return getants2(s, 0,memorization);
}
private  int getants2(String s,int start,HashMap<Integer,Integer> memorization ){
    if (start == s.length()) return 1;//递归出口
    if (s.charAt(start) == '0') return 0;
    int  m=memorization.getOrDefault(start,-1);
    if (m!=-1){
        return m;
    }
    int ant1=getants2(s,start+1,memorization);
    int ant2=0;
    if (start<s.length()-1){
        int ten=(s.charAt(start)-'0')*10;
        int one=s.charAt(start+1)-'0';
        if (ten+one<=26){
            ant2=getants2(s,start+2,memorization);
        }
    }
    memorization.put(start,ant1+ant2);
    return ant1+ant2;
}

//方法三：动态规划
//算法思想： 利用dp 数组， dp [ i ] 代表字符串 s [ i, s.len-1 ]，也就是 s 从 i 开始到结尾的字符串的解码方式。
//    所以dp[i]=dp[i+1]+dp[i+2];
    public int numDecodings3(String s){
        int len=s.length();
//        int[] dp=new int[len+1];
        int[] dp=new int[3];//空间优化 实际上只用到了数组dp的三个值 dp[i]、dp[i+1]、dp[i+2]
        dp[len%3]=1;
        if (s.charAt(len - 1) != '0') {
            dp[(len - 1)%3] = 1;
        }
        for (int i=len-2;i>=0;i--){
            if (s.charAt(i) == '0') {
                dp[i%3]=0;//空间复用了 要归零
                continue;
            }
            int ant1=dp[(i+1)%3];
            int ant2=0;
            int ten=(s.charAt(i)-'0')*10;
            int one=s.charAt(i+1)-'0';
            if (ten+one<=26){
                ant2=dp[(i+2)%3];
            }
            dp[i%3]=ant1+ant2;
        }
        return  dp[0];
    }

    public static void main(String[] args) {
        LeetCode_91 test=new LeetCode_91();
        System.out.println(test.numDecodings3("12"));
    }
}
