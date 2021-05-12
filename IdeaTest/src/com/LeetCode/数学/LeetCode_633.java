package com.LeetCode.数学;

public class LeetCode_633 {
//    超时
    public boolean judgeSquareSum_1(int c) {
        for (int a=0;a<Math.sqrt(c);a++){
            int b= (int) Math.sqrt(c-a*a);
                if (a*a+b*b==c)
                    return true;
            }

        return false;
    }
//    双指针
public boolean judgeSquareSum(int c) {
        int a=0;
        int b= (int) Math.sqrt(c);
        while (a<=b){
            if (a*a+b*b>c){
                b--;
            }
            else if (a*a+b*b<c){
                a++;
            }else {
                return true;
            }
        }
return false;
}
}
