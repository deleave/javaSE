package com.LeetCode.排序;

import java.util.Arrays;
import java.util.Comparator;

public class LeetCode_179 {
    public String largestNumber(int[] nums) {

        int n=nums.length;
        if (n==0)
            return "";
        String[] strings=new String[n];
        for (int i=0;i<n;i++){
            //整形数组转换为字符串数组方法
            strings[i]=String.valueOf(nums[i]);
        }
        //重写排序方法
//        Arrays.sort(要排序的数据,Comparator实例（否则就字典排序）);
       /* Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
//                str1.compareTo(str2) 按字典顺序比较两个字符串。
//               *** 字典顺序的逆序就是数字字符串的大小 ***
//                true返回，false不返回
                return (o2+o1).compareTo((o1+o2));
            }
        });*/
//        lambda表达式写法 速度稍快一些
        Arrays.sort(strings,(o1,o2) ->(o2+o1).compareTo(o1+o2));

        StringBuffer sb=new StringBuffer();
        for (String s:strings
             ) {
            sb.append(s);
        }
        //charAt()  返回 指定索引 处的 char值。
        if(sb.toString().charAt(0)=='0')
            return "0";
        return sb.toString();

    }
}
