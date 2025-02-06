package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//62. Unique Paths
//https://leetcode.com/problems/unique-paths/description/
public class UniquePaths {
    //Approach1
    //Recurrsion + Memonization
    class Approach1{
        private int get(int m,int n,int[][] dp){
            if(m==1 && n==1) return 1;
            if(m<=0 || n<=0) return 0;
            if(dp[m][n]!=-1) return dp[m][n];
            int t1=0;
            int t2=0;
            t1+=get(m,n-1,dp);
            t2+=get(m-1,n,dp);

            return dp[m][n]= t1+t2;
        }

        public int uniquePaths(int m, int n) {
            int[][] dp=new int[m+1][n+1];

            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i==0 || j==0) dp[i][j]=0;
                    else if(i==1 && j==1) dp[i][j]=1;
                    else{
                        int t1=dp[i][j-1];
                        int t2=dp[i-1][j];
                        dp[i][j]=t1+t2;
                    }
                }
            }

            return dp[m][n];

        }
    }

    //Approach2
    //Buttom up from above

    class Approach2{
        public int uniquePaths(int m, int n) {
            int[][] dp=new int[m+1][n+1];

            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    if(i==0 || j==0) dp[i][j]=0;
                    else if(i==1 && j==1) dp[i][j]=1;
                    else{
                        int t1=dp[i][j-1];
                        int t2=dp[i-1][j];
                        dp[i][j]=t1+t2;
                    }
                }
            }

            return dp[m][n];

        }
    }
}
