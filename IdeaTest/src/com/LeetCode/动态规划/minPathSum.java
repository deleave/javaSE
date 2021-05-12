package com.LeetCode.动态规划;
//状态方程 dp[i][j]=min{dp[i-1][j],dp[i][j-1]}+grid[i][j];
public class minPathSum {
    public int minPathSum1(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] dp = new int[grid.length][grid[0].length];//二维数组的初始化
        //grid.length表示行数
        //grid[0].length表示列数
        for (int i = 1; i <grid.length; i++) {
         dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int j=1;j< grid[0].length;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j-1];
        }
        for (int i=1;i<grid.length;i++){
            for (int j=1;j<grid[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}
