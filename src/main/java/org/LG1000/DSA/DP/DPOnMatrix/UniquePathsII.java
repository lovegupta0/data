package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//63. Unique Paths II
//https://leetcode.com/problems/unique-paths-ii/description/
public class UniquePathsII {

    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int[][] grid,int n,int m,int[][] dp){
            if(n==1 && m==1 && grid[n-1][m-1]==0) return 1;
            if(n<=0 || m<=0 || grid[n-1][m-1]==1) return 0;

            if(dp[n][m]!=-1) return dp[n][m];

            int t1=get(grid,n-1,m,dp);
            int t2=get(grid,n,m-1,dp);

            return dp[n][m]= t1+t2;
        }
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n= obstacleGrid.length;
            int m= obstacleGrid[0].length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],-1);
            }

            return get(obstacleGrid,n,m,dp);
        }
    }

    //Approach2
    //Buttom up from above

    class Approach2{
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int n= obstacleGrid.length;
            int m= obstacleGrid[0].length;
            int[][] dp=new int[n+1][m+1];

            for(int i=0;i<=n;i++){
                for(int j=0;j<=m;j++){
                    if(i==0 || j==0 || obstacleGrid[i-1][j-1]==1) dp[i][j]=0;
                    else if(i==1 && j==1 && obstacleGrid[i-1][j-1]==0) dp[i][j]=1;
                    else{
                        int t1=dp[i-1][j];
                        int t2=dp[i][j-1];
                        dp[i][j]=t1+t2;
                    }
                }
            }

            return dp[n][m];
        }
    }
}
