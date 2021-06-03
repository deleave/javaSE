package com.LeetCode.String;

/**
 * @ClassName LeetCode_5
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/21 12:05
 * @Version 1.0
 **/
public class LeetCode_5 {
    //暴力破解  列举所有的子串，判断是否为回文串，保存最长的回文串
    public String longestPalindrome(String s) {
        String ans="";
        int max=0;
        int len=s.length();
        for (int i=0;i<len;i++){
            for (int j=i+1;j<len;j++) {
                String sub = s.substring(i, j);
                //是回文子串 更新ans 和 max
                if (isPalindromic(sub)&&sub.length()>max){
                    ans=sub;
                    max=Math.max(max,ans.length());
                }
            }
        }
        return ans;
    }

    private boolean isPalindromic(String sub) {
        int len=sub.length();
        //比较字符串两边是否相等
        for (int i=0;i<len/2;i++){
            if (sub.charAt(i)!=sub.charAt(len-i-1)){
                return  false;
            }
        }
        return true;
    }

    //暴力破解优化
    public  String longestPalindrome1(String s){
        int length=s.length();
        boolean[][] p=new boolean[length][length];
        int maxlen=0;
        String maxStr="";
        for (int len=1; len<=length;len++){
            for (int start = 0;start<length;start++){
                int end=len-1+start;
                if (end>length){
                    break;
                }
                 p[start][end] = (len == 1 || len == 2 || p[start + 1][end - 1] )&& s.charAt(start) == s.charAt(end);
                if (p[start][end]&&len>maxlen){
                    maxStr=s.substring(start,end+1);
                }
            }
        }
      return maxStr;
    }

//    继续空间复杂度优化
    public  String longestPalindrome2(String s) {

        int n=s.length();
        boolean[] dp=new boolean[n];
        String ans="";
        for (int i=n-1;i>=0;i--){
            for (int j=n-1;j>=i;j--){
                dp[j]=s.charAt(i)==s.charAt(j)&&(j-i>3&&dp[j-1]);
                if (dp[j]&&j-i+1>ans.length()){
                    ans=s.substring(i,j+1);
                }
            }
        }
        return ans;
    }

    //扩展中心
    public  String longestPalindrome3(String s) {
        int n=s.length();
        int start=0,end=0;
        //逐一寻找扩展中心
        for (int i=0;i<n;i++){
            int len1=expandAroundCenter(s,i,i);//奇数字符串的扩展中心
            int len2=expandAroundCenter(s,i,i+1);//偶数字符串的扩展中心
            int len=Math.max(len1,len2);//最长的回文字符串的长度
            //更新 回文字符串的边界
            if (len>end-start){
                start=i-(len-1)/2;
                end=i-len/2;
            }
        }
        return s.substring(start,end+1);
    }

    //返回最长的
    private int expandAroundCenter(String s, int left,int right) {
        int L=left ,R=right;
        while (L>=0&&R<s.length()&&s.charAt(L)==s.charAt(R) ){
            L--;
            R++;
        }
        return R-L+1;
    }


}
