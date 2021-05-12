package com.LeetCode.动态规划;
//
public class LeetCode_87 {
    public static boolean isScramble(String s1, String s2) {
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        int n=s1.length();
        int m=s2.length();
        boolean[][][] dp=new boolean[n][n][n+1];
        if (n!=m) return false;
        //len==1的情况
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                dp[i][j][1]=str1[i]==str2[j];
            }
        }
        //枚举扰乱区间的长度
        for(int len=2;len<=n;len++){
            //枚举S1的起点位置
            for (int i=0;i<=n-len;i++){
                //枚举T1的起点位置
                for (int j=0;j<=n-len;j++){
                    //枚举分割的位置
                    for (int k=1;k<=len-1;k++){
                        //S1->T1
                        // S2->T2
                        if (dp[i][j][k]&&dp[i+k][j+k][len-k]){
                            dp[i][j][len]=true;
                            break;
                        }
                        //S1->T2 S2->T1
                        if (dp[i][j+len-k][k]&&dp[i+k][j][len-k]){
                            dp[i][j][len]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];

    }

    public static void main(String[] args) {

        System.out.println(isScramble("abb","bba"));
    }
}
