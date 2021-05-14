package com.LeetCode.Array;

/**
 * @ClassName LeetCode_12
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/14 10:38
 * @Version 1.0
 **/
public class LeetCode_12 {
    public static String intToRoman(int num) {
        int[] values=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] Str=new String[]{"M","DM","D","CD","C","LC","L","XL","X","IX","V","IV","I"};
        StringBuffer srb=new StringBuffer();
        for (int i=0;i<values.length;i++){
            while (num>=values[i]){
                num-=values[i];
                srb.append(Str[i]);
            }
        }
        return srb.toString();
    }

    public static void main(String[] args) {
        System.out.println( intToRoman(1041));

    }
}
