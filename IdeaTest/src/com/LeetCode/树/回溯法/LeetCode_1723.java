package com.LeetCode.树.回溯法;

import java.util.Arrays;

/**
 * @ClassName LeetCode_1723
 * @Description TODO
 * @Author deleave
 * @Date 2021/5/8 14:03
 * @Version 1.0
 **/
public class LeetCode_1723 {
    //方法一：dfs搜索树+剪枝搜索
    int[] jobs1;
    int k1,n;
    int ans=0x3f3f3f3f;
    public int minimumTimeRequired(int[] jobs, int k) {
        n=jobs.length;
        jobs1=jobs;
        k1=k;
        int[] sum=new int[k+1];
        dfs(0,0,sum,0);
        return ans;
    }
    /*
     * m 为第几个任务
     * sum[0] 指0号工人的工作时间
     * max 最大工作时间
     * worked 工作的人数
     * */
    private void dfs(int m,int worked,int[] sum,int max){
        if (max>=ans) return;
        if (m==n){
            ans=max;
            return;
        }
        if(worked<k1){
            sum[worked]=jobs1[m];
            dfs(m+1,worked+1,sum,Math.max(sum[worked],max));
            sum[worked]=0;
        }
        for (int i=0;i<worked;i++){
            sum[i]+=jobs1[m];
            dfs(m+1,worked,sum,Math.max(sum[i],max));
            sum[i]-=jobs1[m];
        }
    }

    //    方法二：回溯法+二分查找+剪枝
    public int minimumTimeRequired2(int[] jobs, int k) {
        Arrays.sort(jobs);
        int n=jobs.length;
        int l=jobs[n-1]; int r=Arrays.stream(jobs).sum();
        while (l<r){
            int mid=(l+r)>>1;
            if (checked(jobs,k,mid)){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return  l;
    }
    /*
     *@ClassName LeetCode_1723
     *@Description
     *@Author deleave
     *@Date 2021/5/8 15:20
     *@Param [jobs, k, limit] limit指工人最大工作时间 k为工人数  jobs为任务
     **/
    private boolean checked(int[] jobs,int k,int limit){
        int[] workloads=new int[k];
        return backtrack(jobs,workloads,0,limit);
    }
    /*
     *@ClassName LeetCode_1723
     *@Description
     *@Author deleave
     *@Date 2021/5/8 15:23
     *@Param [jobs, workloads, u, limit] workloads[i]指第i个工人当前工作时间 u指当前第u个任务
     **/
    private boolean backtrack(int[] jobs, int[] workloads, int u, int limit) {
        if (u>=jobs.length) return true;
        int cur=jobs[u];
        for (int j=0;j<workloads.length;j++){
            if (workloads[j]+cur<=limit){
                workloads[j]+=cur;
                if (backtrack(jobs,workloads,u+1,limit)){
                    return true;
                }
                workloads[j]-=cur;
            }

            if (workloads[j]==0||workloads[j]+cur==limit){
                break;
            }
        }
        return false;
    }
}
