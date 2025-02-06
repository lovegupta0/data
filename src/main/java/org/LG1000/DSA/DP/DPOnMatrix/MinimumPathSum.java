package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//64. Minimum Path Sum
//https://leetcode.com/problems/minimum-path-sum/description/
public class MinimumPathSum {
    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int[][] grid,int n,int m,int[][] dp){
            if(n==1 && m==1) return grid[n-1][m-1];
            if(n<=0 || m<=0) return 200000;
            if(dp[n][m]!=-1) return dp[n][m];
            int t1=grid[n-1][m-1];

            return dp[n][m]= t1+Math.min(get(grid,n-1,m,dp),get(grid,n,m-1,dp));
        }

        public int minPathSum(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return  get(grid,n,m,dp);
        }
    }

    //Approach2
    //Buttom up from above

    class Approach2{
        public int minPathSum(int[][] grid) {
            int n=grid.length;
            int m=grid[0].length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0) dp[i][j]=2000000;
                    else if(i==1 && j==1) dp[i][j]=grid[i-1][j-1];
                    else{
                        int t1=grid[i-1][j-1];
                        dp[i][j]=t1+Math.min(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }

            return  dp[n][m];
        }
    }
}
