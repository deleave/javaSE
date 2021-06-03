package com.LeetCode.动态规划;

/**
 * @ClassName LeetCode_10
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/29 16:22
 * @Version 1.0
 **/
public class LeetCode_10 {

    //递归算法思想: 假定我们已经解决了问题，并且有了解决这个问题的函数。判断是否匹配的函数 isMath(String s,String p)
    // 将问题从 n 的规模降到 n - 1 的规模。 : s 和 patten 的第一个字符匹配并且剩下的字符也匹配
    // 寻找递归出口: s和p都为空时,代表匹配上了
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();

        //s不为空,且s和p第一个字符匹配 或者p的第一个字符为'.' 可以匹配任意字符
        boolean first_match=(!s.isEmpty()&&p.charAt(0)==s.charAt(0)||p.charAt(0)=='.');

        //当s的长度大于2时再来考虑 '*':匹配前一个字符0次或多次
        if (p.length()>=2&&p.charAt(1)=='*'){

            //两种情况  1.'*' 匹配了前一个字符0次 ,直接跳过p的前两个字符 2.p不变,s往后匹配一个字符
            return (isMatch(s,p.substring(2)))||(first_match&&isMatch(s.substring(1),p));

        }else {
            return first_match&&isMatch(s.substring(1),p.substring(1));
        }

    }

    //动态规划
    //dp[i][j]表示 text 从 i 开始到最后，pattern 从 j 开始到最后，此时 text 和 pattern 是否匹配。
    public boolean isMatch1(String s, String p) {


        boolean[][] dp=new boolean[s.length()+1][p.length()+1];

        //dp[len][len]代表 两个空串是否匹配 肯定时ture
        dp[s.length()][p.length()]=true;

        for (int i=s.length();i>=0;i--){
            for (int j=p.length();j>=0;j--){

                //dp[len][len]已经初始化过了
                if (i==s.length()&&j==p.length()) continue;

                boolean first_match=(i<s.length()&&j<p.length())&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.');

                if (j+1<p.length()&&p.charAt(j+1)=='*') {
                    //
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];

                }else {
                    dp[i][j] = first_match&&dp[i + 1][j + 1];
                }



            }
        }
        return dp[0][0];

    }



    }
