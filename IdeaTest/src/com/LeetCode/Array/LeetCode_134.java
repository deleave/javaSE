package com.LeetCode.Array;

/**
 * @ClassName LeetCode_134
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/12 10:52
 * @Version 1.0
 **/
public class LeetCode_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int index=-1;
       int nowGas=0;
       int n=gas.length;
        for (int i=0;i<n;i++){
            if (gas[i]>=cost[i]){
                index=i;
                nowGas=gas[index];
               while (nowGas-cost[index]>=0){
                   nowGas=nowGas-cost[i]+gas[(i+1)%n];
                   index=(index+1)%n;
                   if (index==i){
                       return index;
                   }
               }
            }

        }
        return -1;
    }
    //空间换时间 记录每个站点能到达的最远站点 以及剩余油耗
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        int n=gas.length;
        int[] farIndex=new int[n];
        for (int i=0;i<n;i++){
            farIndex[i]=-1;
        }
        int[] farIndexRemain = new int[n];

        for (int i=0;i<n;i++){
            if (gas[i]>=cost[i]){
                int index = i;
                int nowGas = gas[index];
                while (nowGas-cost[index]>=0){
                    nowGas=nowGas-cost[index];
                    index=(index+1)%n;
                    if (farIndex[index]!=-1){
                        nowGas +=farIndexRemain[index];
                        index=farIndex[index];
                    }else {
                        nowGas+=gas[index];
                    }
                    if (index==i){
                        return index;
                    }
                }
                farIndex[i]=index;
                farIndexRemain[i]=nowGas;
            }

        }
        return -1;
    }

    public int canCompleteCircuit3(int[] gas, int[] cost) {
        int index=-1;
        int nowGas=0;
        int n=gas.length;
        for (int i=0;i<n;i++){
                index=i;
                nowGas=gas[index];
                while (nowGas-cost[index]>=0){
                    nowGas=nowGas-cost[i]+gas[(i+1)%n];
                    index=(index+1)%n;
                    if (index==i){
                        return index;
                    }
                }
        if (index<i){
            return -1;
        }
        i=index;
        }
        return -1;
    }
}
