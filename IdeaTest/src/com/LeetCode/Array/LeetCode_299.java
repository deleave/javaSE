package com.LeetCode.Array;

import java.util.HashMap;

/**
 * @ClassName LeetCode_299
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/11 15:45
 * @Version 1.0
 **/
public class LeetCode_299 {
    public String getHint(String secret, String guess) {
        HashMap<Character,Integer> mapS=new HashMap<Character,Integer>();
        HashMap<Character,Integer> mapG=new HashMap<Character,Integer>();
        int A=0;
        for (int i=0;i<secret.length();i++){
            if (secret.charAt(i)==guess.charAt(i)){
                A++;
            }
        }

        for (int i=0;i<secret.length();i++){
            mapS.put(secret.charAt(i),mapS.getOrDefault(secret.charAt(i),0)+1 );
            mapG.put(secret.charAt(i), mapG.getOrDefault(secret.charAt(i),0)+1 );
        }
        int B=0;
        for (Character key: mapS.keySet()){
            int n1=mapS.getOrDefault(key,0);
            int n2=mapG.getOrDefault(key,0);
            B+=Math.min(n1,n2);
        }
        return A+"A"+(B-A)+"B";
    }
    //优化：1.因为map的key最多为0—9,可以用数组代替
    //2.第二个循环可以放在第一个中，当位置不同时再统计B
    public String getHint2(String secret, String guess) {
        int[] mapS=new int[10];
        int[] mapG=new int[10];
        int A=0;
        for (int i=0;i<guess.length();i++){
            if (secret.charAt(i)==guess.charAt(i)){
                A++;
            }else {
                mapS[secret.charAt(i)-'0']++;
                mapG[guess.charAt(i)-'0']++;
            }
        }
        int B=0;
        for (int i=0;i<10;i++){
            B+=Math.min(mapS[i],mapG[i]);
        }
        return A+"A"+B+"B";
    }

    //优解 遇s n[s]++，遇g n[g]--;
    public String getHint3(String secret, String guess) {
        int[] numbers=new int[10];
        int bulls=0;
        int cow=0;
        for (int i=0;i<secret.length();i++){
            int s=secret.charAt(i)-'0';
            int g=guess.charAt(i)-'0';
            if (s==g){
                bulls++;
            }else {
                if (numbers[s]<0) cow++;
                if (numbers[g]>0) cow++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls+"A"+cow+"B";
    }

}
