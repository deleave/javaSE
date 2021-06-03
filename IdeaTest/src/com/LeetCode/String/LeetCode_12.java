package com.LeetCode.String;

/**
 * @ClassName LeetCode_12
 * @Description TODO
 * @Author deleave
 * @Date 2021/6/2 10:17
 * @Version 1.0
 **/
public class LeetCode_12 {
    public String longestCommonPrefix(String[] strs) {
      int len=strs.length;
      if (len==0) return "";
      String ans=strs[0];
      for (int i=0;i<len;i++){
          //startsWith()方法是一个String类方法，用于检查给定的字符串是否以特定的字符序列开头。
          while (!strs[i].startsWith(ans)){
              if (ans.length()==0) return "";
              ans=ans.substring(0,ans.length()-1);
          }
      }
      return ans;

    }

    //比较每一列,直到有不一样的
    public  String longestCommonPrefix1(String[] strs) {
        int length = strs.length;
        if (length==0) return "";

        int minlen=Integer.MAX_VALUE;
        for (String s: strs
             ) {
            if (s.length()==0) return "";
            if (s.length()<minlen){
                minlen=s.length();
            }
        }


        int i=0;
        for (;i<minlen;i++){
            if (!isSameAtIndex(strs,i)){
                break;
            }
        }
        return strs[0].substring(0,i);
    }

    private boolean isSameAtIndex(String[] strs, int index) {
        int i=0;
        while (i<strs.length-1){
            if (strs[i].charAt(index)==strs[i+1].charAt(index)){
                i++;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode_12 solusion = new LeetCode_12();
        String[] strings={"ab","b"};
        String s = solusion.longestCommonPrefix1(strings);
        System.out.println(s);
    }


}
