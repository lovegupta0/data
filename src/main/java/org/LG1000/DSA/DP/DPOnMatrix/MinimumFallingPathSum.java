package org.LG1000.DSA.DP.DPOnMatrix;
import java.util.*;

//931. Minimum Falling Path Sum
//https://leetcode.com/problems/minimum-falling-path-sum/description/
public class MinimumFallingPathSum {

    //Approach1
    //Recurrsion + Memomization
    class Approach1{
        private int get(int[][] matrix,int n,int m,int[][] dp){
            if(n==0) return 0;
            if(m>matrix[0].length || m<=0) return 10000;

            if(dp[n][m]!=Integer.MIN_VALUE) return dp[n][m];

            int data=matrix[n-1][m-1];
            int t1=data+get(matrix,n-1,m,dp);
            int t2=data+get(matrix,n-1,m-1,dp);
            int t3=data+get(matrix,n-1,m+1,dp);
            int temp=Math.min(t1,Math.min(t2,t3));
            if(n==matrix.length){
                temp=Math.min(temp,get(matrix,n,m-1,dp));
            }
            return dp[n][m]= temp;
        }
        public int minFallingPathSum(int[][] matrix) {
            int n=matrix.length;
            int m=matrix[0].length;

            int[][] dp=new int[n+1][m+1];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],Integer.MIN_VALUE);
            }

            return get(matrix,n,m,dp);
        }
    }

    //Approach2
    //Buttom up

    class Approach2{
        public int minFallingPathSum(int[][] matrix) {
            int n=matrix.length;
            int m=matrix[0].length;
            int min=Integer.MAX_VALUE;

            int[][] dp=new int[n+2][m+2];
            for(int i=0;i<=n;i++){
                Arrays.fill(dp[i],10000);
            }
            Arrays.fill(dp[0],0);

            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    int data=matrix[i-1][j-1];
                    int temp=data+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                    dp[i][j]=Math.min(dp[i][j],temp);
                }
            }

            for(int i=0;i<=m;i++){
                min=Math.min(min,dp[n][i]);
            }
            return min;
        }
    }
}
