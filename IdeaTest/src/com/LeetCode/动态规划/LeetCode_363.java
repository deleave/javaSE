package com.LeetCode.动态规划;

import org.junit.Test;

import java.util.TreeSet;

public class LeetCode_363 {
    //暴力枚举+动态规划
    // dp[i1][j1]=dp[i1-1][j1]+dp[i1][j1-1]-dp[i1-1][j1-1]+matrix[i1-1][j1-1]; 去重加边
    public int maxSumSubmatrix1(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int max=Integer.MIN_VALUE;
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                int[][] dp=new int[m+1][n+1];
                dp[i][j]=matrix[i-1][j-1];
                for (int i1=i;i1<=m;i1++){
                    for (int j1=j;j1<=n;j1++){
                        dp[i1][j1]=dp[i1-1][j1]+dp[i1][j1-1]-dp[i1-1][j1-1]+matrix[i1-1][j1-1];
                        if (dp[i1][j1]<=k&&dp[i1][j1]>max)
                            max=dp[i1][j1];
                    }
                }
            }
        }
        return max;
    }

    //滚动数组
    // 思想：固定左右边界，只考虑行，在哪两个行之间组成矩形的面积最大。
    public  int maxSumSubmatrix(int[][] matrix, int k) {
        int row=matrix.length;
        int cols=matrix[0].length;
        int max=Integer.MIN_VALUE;
        for (int l=0;l<cols;l++){//固定左边界
            int[] rowsum=new int[row];//左边界移动
            for (int r=l;r<cols;r++) {
                for (int i = 0; i < row; i++) {
                    rowsum[i] += matrix[i][r];
                }

                max = Math.max(max, dpmax(rowsum, k));
                if (max == k) return k;
            }
        }
        return max;
    }
    private int dpmax(int[] rowsum,int k){
        int all_sum=rowsum[0];
        int max_sum=rowsum[0];
        for (int i=1;i<rowsum.length;i++){
            if (all_sum>0) all_sum+=rowsum[i];
            else all_sum=rowsum[i];
            max_sum=Math.max(all_sum,max_sum);
        }
        if (max_sum==k) return k;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<rowsum.length;i++) {
            int sum = 0;
            for (int j = i; j < rowsum.length; j++) {
                sum += rowsum[j];
                if (sum > max && sum <= k) max = sum;
            }
        }
        return max;
    }

    public int maxSumSubmatrix2(int[][] matrix,int k) {
        int row = matrix.length;
        int cols = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < cols; l++) {//按照左右边界求得滑动数组
            int[] rowsum = new int[row];//左边界改变 区域重新开始
            for (int r = l; r < cols; r++) {
                for (int i = 0; i < row; i++) {
                    //求得每行和
                    rowsum[i] += matrix[i][r];
                }
                //计算每行rowsum数组和的最大值
                int sum=0;
                int res=rowsum[0];
                for (int x:rowsum){
                    sum=Math.max(sum+x,x);
                    res=Math.max(sum,res);
                    if (res==k) return k;//提前结束
                }
                if (res<k) {
                    max=Math.max(res,max);
                }else {
                    //继续计算和值
                    for (int i=0;i<row;i++){
                        int curSum=0;
                        for (int j=i;j<row;j++){
                            curSum+=rowsum[j];
                            if (curSum<k){
                                max=Math.max(max,curSum);
                            }else if (curSum==k) {
                                return k;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }
    //优化：利用TreeSet数据结构 和ceiling求上界方法
    public int maxSumSubmatrix3(int[][] matrix, int k) {
            int ans = Integer.MIN_VALUE;
            int m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; ++i) { // 枚举上边界
                int[] sum = new int[n];
                for (int j = i; j < m; ++j) { // 枚举下边界
                    for (int c = 0; c < n; ++c) {
                        sum[c] += matrix[j][c]; // 更新每列的元素和
                    }
                    TreeSet<Integer> sumSet = new TreeSet<Integer>();
                    sumSet.add(0);
                    int s = 0;
                    for (int v : sum) {
                        s += v;
                        Integer ceil = sumSet.ceiling(s - k);
                        if (ceil != null) {
                            ans = Math.max(ans, s - ceil);
                        }
                        sumSet.add(s);
                    }
                }
            }
            return ans;
        }


    public static void main(String[] args) {
        int[][] max={{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        LeetCode_363 leetCode_363=new LeetCode_363();
        System.out.println(leetCode_363.maxSumSubmatrix2(max,-2));
    }

}
