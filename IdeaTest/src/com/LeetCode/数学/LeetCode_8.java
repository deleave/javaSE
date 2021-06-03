package com.LeetCode.数学;

/**
 * @ClassName LeetCode_8
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/26 9:13
 * @Version 1.0
 **/
public class LeetCode_8 {
    public int myAtoi(String s) {
        int index=0;
        char[] str=s.toCharArray();
        int n=s.length();
        while (index<n&&str[index]==' '){
            index++;//去除前导空格
        }

        if (index>n){
            return 0;//无数字,返回0
        }
        boolean negative=false;//判断正负号

        if (str[index]=='-'){
            negative=true;
            index++;
        }else if (str[index]=='+'){
            index++;
        }else if (!Character.isDigit(str[index])) {
            //如果是其他符号
            // Character.isDigit(char c)判断字符c是不是以数字形式的字符
            return 0;
        }

        int ans=0;
        while (index<n&&Character.isDigit(str[index])){
            int digit=str[index]-'0';
            if (ans>(Integer.MAX_VALUE-digit)/10){
                //数字越界
                return negative?Integer.MAX_VALUE:Integer.MAX_VALUE;
            }
            ans=ans*10+digit;
            index++;

        }
        return negative?-ans:ans;
    }

}
