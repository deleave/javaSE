package com.LeetCode.String;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName LeetCode_6
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/22 10:53
 * @Version 1.0
 **/
public class LeetCode_6 {
    //直接按照z字顺序遍历 将遍历结果放入numRows个可变长字符串中 最后连接起来
    public  String convert(String s, int numRows) {
        if(numRows==1) return s;

        List<StringBuffer> rows=new ArrayList<>();
        for (int i=0;i<Math.min(numRows,s.length());i++){
            rows.add(new StringBuffer());
        }

        int curRow=0;//当前行数
        boolean goingDown =false;//判断是否改变遍历方向

        //核心代码:利用goingDown改变遍历方向
        for (char c:s.toCharArray()
             ) {
            //将c拼接到第curRow个字符串上
            rows.get(curRow).append(c);
            //到达第一行或者最后一行改变遍历方向
            if (curRow==0||curRow==numRows-1){
                goingDown=!goingDown;
            }
            //
            curRow+=goingDown?1:-1;
        }
        //最后拼接在一起
        StringBuffer ret=new StringBuffer();
        for (StringBuffer row:rows){
            ret.append(row);
        }
        return ret.toString();

    }

    //根据下标找规律
    public  String convert1(String s, int numRows) {
        if (numRows==1) return s;

        StringBuffer ret=new StringBuffer();
        int cycleLen=2*numRows-2;
        int n=s.length();
//        逐行遍历
        for (int i=0;i<numRows;i++){
            //逐个周期遍历
            for (int j=0;j+i<n;j+=cycleLen){
                //第i行第一个字符
                ret.append(s.charAt(j+i));
                //去掉第0行和最后一行只有一个字符的情况
                if (i!=0&&i!=numRows-1&&j+cycleLen-i<n){
                    //第i行第二个字符
                    ret.append(s.charAt(j+cycleLen-i));
                }
            }
        }
        return ret.toString();
    }




}
